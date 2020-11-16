package com.atspirit.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Valor
 * @create: 2020/11/15
 * @Description:
 * @FileName: ConfigClientController
 * @History:
 * @自定义内容：
 */
@RestController
@RefreshScope
public class ConfigClientController {

    //    @Value("${document}")
    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
