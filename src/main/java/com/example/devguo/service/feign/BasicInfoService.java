package com.example.devguo.service.feign;

import com.example.devguo.service.fallback.BasicInfoServiceFallBack;
import org.springframework.cloud.client.loadbalancer.reactive.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

/**
 * @Author: dev_guo
 * @Date: 2022/2/10 16:28
 */
@FeignClient(value = "public-server",fallback = BasicInfoServiceFallBack.class)
public interface BasicInfoService {
    @PostMapping("/api/basicInfo/getProductDetails")
    Response getProductDetails(Map<String,Object> feignParam);
}
