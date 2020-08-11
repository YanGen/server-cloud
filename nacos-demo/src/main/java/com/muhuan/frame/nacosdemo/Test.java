package com.muhuan.frame.nacosdemo;

import com.muhuan.frame.common.bean.BaseEntity;

/**
 * @ClassName Test
 * @Description TODO
 * @Author geng <yg.db@uniteddata.com>
 * @Date 2020/8/10
 * @Version 1.0.0
 **/
public class Test<A> {
    private A test;

    public A getTest() {
        return test;
    }

    public void setTest(A test) {
        this.test = test;
    }

    public static void main(String[] args) {
        Test test = new Test<>();
        Test<String> stest = new Test<>();
    }
}
