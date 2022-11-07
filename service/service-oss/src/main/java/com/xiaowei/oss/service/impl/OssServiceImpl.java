package com.xiaowei.oss.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.PutObjectResult;
import com.xiaowei.oss.config.OssConfiguration;
import com.xiaowei.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {
    @Autowired
    private OssConfiguration ossConfiguration;
    @Override
    public String upload(MultipartFile file) {
        //获取阿里云存储相关常量
        String endPoint = ossConfiguration.getEndpoint();
        String accessKeyId = ossConfiguration.getKeyId();
        String accessKeySecret = ossConfiguration.getKeySecret();
        String bucketName = ossConfiguration.getBucketName();
//        String fileHost = ConstantPropertiesUtil.FILE_HOST;
        String uploadUrl = null;
        try {
            //判断oss实例是否存在：如果不存在则创建，如果存在则获取
            OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
            if (!ossClient.doesBucketExist(bucketName)) {
                //创建bucket
                ossClient.createBucket(bucketName);
                //设置oss实例的访问权限：公共读
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            }
            //获取上传文件流
            InputStream inputStream = file.getInputStream();
            //构建日期路径：avatar/2019/02/26/文件名
//            String filePath = new DateTime().toString("yyyy/MM/dd");
            //文件名：uuid.扩展名
            String original = file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString();
            String fileType = original.substring(original.lastIndexOf("."));
            String newName = uuid + fileType;
            //文件上传至阿里云
            ossClient.putObject(bucketName, newName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            //获取url地址
            uploadUrl = "https://" + bucketName + "." + endPoint + "/" + newName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uploadUrl;
    }
}
