package com.muhuan.frame.gateway.rollback;

import com.muhuan.frame.common.bean.ResultBean;
import com.muhuan.frame.common.bean.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayFeginFallback {

    @RequestMapping(value = "/GatewayFallback")
    public ResultBean GatewayFallback() {
        return ResultBean.defeated("GatewayFallback");
    }
}
