package com.atspirit.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Valor
 * @create: 2020/11/10
 * @Description:
 * @FileName: GatewayConfigBean
 * @History:
 * @自定义内容：
 */
@Configuration
public class GatewayConfigBean {

    @Bean
    public RouteLocator getRouteBean(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_test",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
