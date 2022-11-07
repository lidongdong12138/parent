package com.xiaowei.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EduConfig {

    @Bean
    public ISqlInjector iSqlInjector()
    {
        return new LogicSqlInjector();
    }
}
