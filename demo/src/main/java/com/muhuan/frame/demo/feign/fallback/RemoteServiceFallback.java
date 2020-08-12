package com.muhuan.frame.demo.feign.fallback;

import com.muhuan.frame.common.bean.ResultBean;
import com.muhuan.frame.demo.feign.RemoteService;
import org.springframework.stereotype.Service;

/**
 * @ClassName RemoteServiceFallback
 * @Description TODO
 * @Author geng <yg.db@uniteddata.com>
 * @Date 2020/8/12
 * @Version 1.0.0
 **/
@Service
public class RemoteServiceFallback implements RemoteService {
    @Override
    public ResultBean get() {
        return ResultBean.defeated("远程过程出错...");
    }
}
