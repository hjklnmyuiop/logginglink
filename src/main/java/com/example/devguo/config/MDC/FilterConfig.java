package com.example.devguo.config.MDC;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: zhen_huang
 * @Date: 2020/11/23/14:52
 * @Description:注册过滤器
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MDCFilter());
        registration.addUrlPatterns("/*");
        registration.setName("MDCFilter");
        registration.setOrder(1);
        return registration;
    }
}
