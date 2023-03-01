package com.example.devguo.config.MDC;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.slf4j.MDC;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @authoer: Wain_huang
 * @createDate: 2022/6/23
 * @description: 日志追踪- fegin基于Hystrix，解决Hystrix线程池中子线程未继承MDC问题
 */
public class MdcHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {
    //重写wrapCallable  保证MDC 在fegin 中的传递
    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        return () -> {
            try {
                MDC.setContextMap(contextMap);
                return callable.call();
            } finally {
                MDC.clear();
            }
        };
    }
}
