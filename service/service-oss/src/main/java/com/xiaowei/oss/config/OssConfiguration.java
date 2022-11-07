package com.xiaowei.oss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "aliyun.oss.file")
public class OssConfiguration {
    private String endpoint;
    private String keyId;
    private String keySecret;
    private String bucketName;
}
