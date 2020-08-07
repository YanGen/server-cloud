package com.muhuan.frame.common.handler;

import com.muhuan.frame.common.bean.ResultBean;

/**
 * @ClassName SentinelFallbackHandler
 * @Description TODO
 * @Author geng <yg.db@uniteddata.com>
 * @Date 2020/8/7
 * @Version 1.0.0
 **/
public class SentinelFallbackHandler {

    public static ResultBean fallBackHandler (Throwable e ) {
        return ResultBean.defeated(e.getMessage());
    }
    public static ResultBean fallBackHandler (long id,Throwable e ) {
        return ResultBean.defeated(e.getMessage());
    }
    public static ResultBean fallBackHandler (String test,Throwable e ) {
        return ResultBean.defeated(e.getMessage());
    }
}
