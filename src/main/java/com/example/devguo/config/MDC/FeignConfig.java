package com.example.devguo.config.MDC;

import com.example.devguo.util.MDC.MDCUtils;
import com.netflix.hystrix.strategy.HystrixPlugins;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @authoer: Wain_huang
 * @createDate: 2022/6/23
 * @description: 日志追踪- fegin传递TRACE_ID
 */
@Slf4j
@Configuration
public class FeignConfig {

    /**
     * 注册hystrix的mdc strategy，传递trace_id
     */
    @PostConstruct
    public void hystrixInit() {
        HystrixPlugins.getInstance().registerConcurrencyStrategy(new MdcHystrixConcurrencyStrategy());
    }
    /**
     * 链路追踪向下传递
     * @return
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        RequestInterceptor requestInterceptor = template -> {
            String traceId = MDCUtils.getTraceId();
            if (traceId != null) {
                template.header(MDCUtils.TRACE_ID, traceId);
            }
        };
        return requestInterceptor;
    }

}