package com.muhuan.frame.demo.feign;

import com.muhuan.frame.common.bean.ResultBean;
import com.muhuan.frame.demo.feign.fallback.RemoteServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName RemoteService
 * @Description TODO
 * @Author geng <yg.db@uniteddata.com>
 * @Date 2020/8/12
 * @Version 1.0.0
 **/
@Component
@FeignClient(name = "remote",fallback = RemoteServiceFallback.class)
public interface RemoteService {
    @RequestMapping("/goods/get")
    ResultBean get();
}
