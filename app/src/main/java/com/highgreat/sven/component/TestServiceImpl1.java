package com.highgreat.sven.component;

import android.util.Log;

import com.highgreat.sven.base.TestService;
import com.highgreat.sven.router_annotation.Route;


@Route(path = "/main/service1")
public class TestServiceImpl1 implements TestService {


    @Override
    public void test() {
        Log.i("Service", "我是app模块测试服务通信1");
    }
}
