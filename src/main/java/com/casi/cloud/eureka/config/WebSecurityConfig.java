package com.casi.cloud.eureka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Classname WebSecurityConfig
 * @Description 启动安全配置，未将SpringCloudEureka 中配置的SpringSecurity 的csrf配置信息禁止
 * 新版（Spring Cloud 2.0 以上）的security默认启用了csrf检验，要在eurekaServer端配置security的csrf检验为false
 *
 * 在 Eureka Server 项目中，增加存放配置的专用包目录；
 * 添加一个继承 WebSecurityConfigurerAdapter 的类；
 * 在类上添加 @EnableWebSecurity 注解；
 * 覆盖父类的 configure(HttpSecurity http) 方法，关闭掉 csrf，至此大工告成。
 *
 * @Date 2019/5/8 9:50
 * @Created by HTZZ
 * @Version 1.0.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);

    }
}
