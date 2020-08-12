package com.muhuan.frame.remote.controller;

import com.muhuan.frame.common.bean.ResultBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GoodsController
 * @Description TODO
 * @Author geng <yg.db@uniteddata.com>
 * @Date 2020/8/12
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResultBean get(){
        return ResultBean.succeed("商品信息");
    }
}
