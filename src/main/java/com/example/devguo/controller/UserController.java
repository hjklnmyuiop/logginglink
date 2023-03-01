package com.example.devguo.controller;

import com.example.devguo.service.feign.BasicInfoService;
import com.example.devguo.service.until.Report;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.reactive.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: dev_guo
 * @Date: 2022/2/7 14:06
 */

@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "用户管理自定义类")
public class UserController {
//    @Autowired
//    public GoodsTypeService goodsTypeService;
@Resource
private BasicInfoService basicInfoService;
    /**
     * 保存数据
     * @param
     * @return
     */
    @PostMapping(value = "/save")
    //方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
    @ApiImplicitParam(name = "user", value = "新增用户数据")
    //说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public void save(){
        log.info("测试");
        System.out.println("hello save");
    }

    @PostMapping(value = "/getinfo")
    @Report(type = 2,level ="ss" ,value ="qq" )
    public void getInfo(){
        Map<String,Object> feignParam = new HashMap<>();
        feignParam.put("account","account");
        feignParam.put("productInfos","productInfos");
        Response productDetails = basicInfoService.getProductDetails(feignParam);
        System.out.println(productDetails);
        log.info("ces");
    }
}
