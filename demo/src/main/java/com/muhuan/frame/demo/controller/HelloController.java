package com.muhuan.frame.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.muhuan.frame.common.bean.ResultBean;
import com.muhuan.frame.common.handler.SentinelBlockHandler;
import com.muhuan.frame.common.handler.SentinelFallbackHandler;
import com.muhuan.frame.demo.util.ExceptionUtil;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author geng <yg.db@uniteddata.com>
 * @Date 2020/7/28
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/test1/{data}")
    @SentinelResource(value = "demo1")
    public ResultBean demo1(@PathVariable("data") String data){
        return ResultBean.succeed(data);
    }

    @GetMapping("/testA")
    @SentinelResource(value="testA",
            blockHandler="handleException",blockHandlerClass= SentinelBlockHandler.class,
            fallback = "fallBackHandler",fallbackClass = SentinelFallbackHandler.class
    )
    public ResultBean demo2(@RequestParam(value = "p1",defaultValue = "Null") String p1){
        if (p1.equals("Null")) {

            throw new RuntimeException("RuntimeException");

        }
        return ResultBean.succeed("testA---");
    }



    @GetMapping("/testC")
    @SentinelResource(value="testC",blockHandler="handleException")
    public ResultBean demo4(){
        return ResultBean.succeed("testA---");
    }

}
