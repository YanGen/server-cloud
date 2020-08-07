package com.muhuan.frame.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.muhuan.frame.common.bean.ResultBean;
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
    @SentinelResource(value="testA",blockHandler="handleException",blockHandlerClass= ExceptionUtil.class)
    public ResultBean demo2(@RequestParam(value = "p1",defaultValue = "Null") String p1){
        return ResultBean.succeed("testA---");
    }
    @GetMapping("/testB")
    @SentinelResource(value="testB",blockHandler="handleException")
    public ResultBean demo3(){
        return ResultBean.succeed("testA---");
    }
    public ResultBean handleException(BlockException e){
        return ResultBean.defeated("扛不住啊。。。");
    }

}
