package com.example.devguo.service.fallback;

import com.example.devguo.service.feign.BasicInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.reactive.Response;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: dev_guo
 * @Date: 2022/2/10 16:37
 */
@Slf4j
@Component
public class BasicInfoServiceFallBack implements BasicInfoService {


    @Override
    public Response getProductDetails(Map<String, Object> feignParam) {
        return null;
    }
}
