package com.muhuan.frame.demo.util;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.muhuan.frame.common.bean.ResultBean;

/**
 * @ClassName ExceptionUtil
 * @Description TODO
 * @Author geng <yg.db@uniteddata.com>
 * @Date 2020/8/5
 * @Version 1.0.0
 **/
public class ExceptionUtil {
    public static ResultBean handleException(String p1,BlockException e) {
        return ResultBean.defeated("扛不住了啊....");
    }
}