package com.example.devguo.util.MDC;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.nacos.common.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import java.util.Random;

/**
 * MDC 用于配合log4j进行日志追踪，可以根据项目需求灵活配置
 * @Description:
 * @Author: hwx
 * @CreateTime: 2021/12/16
 * @Company:
 **/
@Slf4j
public class MDCUtils {

    public static final String TRACE_ID = "traceId";

    /**
     * 注册追踪id
     * @param
     */
    public static void trace(){
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(uniqueId(randomCode(String.valueOf(System.currentTimeMillis()),4)));
            MDC.clear();
            MDC.put(TRACE_ID, sb.toString());
        }catch (Exception e){
            log.warn("日志跟踪初始化失败：{}",e.getMessage());
        }
    }

    /**
     * 注册追踪id
     * @param ipAddr
     */
    public static void trace(String ipAddr){
        if(StringUtils.isEmpty(ipAddr)){
            return;
        }
        try{
            StringBuilder sb = new StringBuilder();
            sb.append(uniqueId(ipAddr));
            sb.append("-").append(uniqueId(randomCode(String.valueOf(System.currentTimeMillis()),4)));
            MDC.clear();
            MDC.put(TRACE_ID, sb.toString());
        }catch (Exception e){
            log.warn("日志跟踪初始化失败：{}",e.getMessage());
        }
    }

    /**
     * 获取追踪id
     * @param
     */
    public static String getTraceId(){
        return MDC.get(TRACE_ID);
    }

    /**
     * 清除MDC
     */
    public static void clear(){
        MDC.clear();
    }

    private static String uniqueId(Long radom) {
        return uniqueId(String.valueOf(radom));
    }

    private static String uniqueId(String radom) {
        try {
           String phash = MD5Utils.md5Hex(radom.getBytes());
           return phash.substring(0, phash.length() / 2);
        }catch (Exception e){
            e.printStackTrace();
            return radom;
        }
    }

    private static String randomCode(String prefix ,int digit ) {
        StringBuilder str = new StringBuilder(prefix);
        Random random = new Random();
        for (int i = 0; i < digit; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
