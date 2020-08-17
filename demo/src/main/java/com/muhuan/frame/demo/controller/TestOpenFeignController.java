package com.muhuan.frame.demo.controller;

import com.muhuan.frame.common.bean.ResultBean;
import com.muhuan.frame.demo.feign.RemoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestOpenFeignController
 * @Description TODO
 * @Author geng <yg.db@uniteddata.com>
 * @Date 2020/8/12
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/feign")
@Slf4j
public class TestOpenFeignController {
    private final RemoteService remoteService;

    public TestOpenFeignController(RemoteService remoteService) {
        this.remoteService = remoteService;
    }

    @RequestMapping("/getGoods")
    public ResultBean getGoods(){
        return remoteService.get();
    }
}
