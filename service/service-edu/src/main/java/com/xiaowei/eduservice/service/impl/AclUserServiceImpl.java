package com.xiaowei.eduservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaowei.eduservice.entity.AclUser;
import com.xiaowei.eduservice.service.AclUserService;
import com.xiaowei.eduservice.mapper.AclUserMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【acl_user(用户表)】的数据库操作Service实现
* @createDate 2022-11-05 16:23:48
*/
@Service
public class AclUserServiceImpl extends ServiceImpl<AclUserMapper, AclUser>
    implements AclUserService{

}




