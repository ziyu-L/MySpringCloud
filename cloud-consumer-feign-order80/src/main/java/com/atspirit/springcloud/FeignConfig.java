package com.atspirit.springcloud;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Valor
 * @data 2020/11/5 0:00
 *
 * 配置日志级别
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level getLog() {
        // 请求和响应的头信息,请求和响应的正文及元数据
        return Logger.Level.FULL;
    }

}
