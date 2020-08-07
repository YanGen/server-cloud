package com.muhuan.frame.common.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.muhuan.frame.common.bean.ResultBean;

/**
 * @ClassName SentinelBlockHandler
 * @Description TODO Sentinel 统一异常处理
 * @Author geng <yg.db@uniteddata.com>
 * @Date 2020/8/7
 * @Version 1.0.0
 **/
public class SentinelBlockHandler {
    public static ResultBean handleException(BlockException e){
        return ResultBean.defeated();
    }
    public static ResultBean handleException(String p1, BlockException e) {
        return ResultBean.defeated("扛不住了啊....");
    }
}
