package com.example.devguo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: dev_guo
 * @Date: 2022/2/7 14:06
 */


@RestController
@RequestMapping("/user")
@Api(value = "用户管理自定义类")
public class UserController {
//    @Autowired
//    public GoodsTypeService goodsTypeService;
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
        System.out.println("hello save");
    }
}
