package com.example.devguo.config.MDC;

import com.alibaba.nacos.common.utils.StringUtils;
import com.example.devguo.util.MDC.IpUtils;
import com.example.devguo.util.MDC.MDCUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * mdc日志追踪 过滤器
 * 
 * @author hwx
 */
@Slf4j
public class MDCFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // 默认从请求中获取trace_id（nginx中生成trace_id）
        String traceId = request.getHeader(MDCUtils.TRACE_ID);
        try {
            if (StringUtils.isNotBlank(traceId)) {
                MDC.clear();
                MDC.put(MDCUtils.TRACE_ID, traceId);
            // 当请求中无trace_id时，默认生成一个
            }else {
                MDCUtils.trace(IpUtils.getIpAddr(request));
            }
        } catch (Exception e){
            log.info("日志追踪生成|继承异常："+e.getMessage());
        }
        filterChain.doFilter(request,response);
    }
}
