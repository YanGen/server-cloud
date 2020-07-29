package com.muhuan.frame.demo.controller;

import com.muhuan.frame.common.bean.ResultBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/{data}")
    public ResultBean demo(@PathVariable("data") String data){
        return ResultBean.succeed(data);
    }

}
