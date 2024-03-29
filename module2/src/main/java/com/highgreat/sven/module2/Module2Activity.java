package com.highgreat.sven.module2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.highgreat.sven.base.TestService;
import com.highgreat.sven.router_annotation.Extra;
import com.highgreat.sven.router_annotation.Route;
import com.highgreat.sven.router_core.HGRouter;

@Route(path = "/module2/test")
public class Module2Activity extends Activity {

    @Extra
    String msg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);
        HGRouter.getInstance().inject(this);
        Log.i("module2", "我是模块2:" + msg);

        TestService testService = (TestService) HGRouter.getInstance().build("/main/service1")
                .navigation();
        testService.test();

        TestService testService1 = (TestService) HGRouter.getInstance().build("/main/service2")
                .navigation();
        testService1.test();

        TestService testService2 = (TestService) HGRouter.getInstance().build("/module1/service")
                .navigation();
        testService2.test();

        TestService testService3 = (TestService) HGRouter.getInstance().build("/module2/service")
                .navigation();
        testService3.test();
        
    }

    public void mainJump(View view) {
//        HGRouter.getInstance().build("/main/test").withString("a","从Module2").navigation(this);
//        if (BuildConfig.isModule){
            HGRouter.getInstance().build("/main/test").withString("a",
                    "从Module2").navigation(this);
//        }else{
//            Toast.makeText(this,"当前处于组件模式,无法使用此功能",
//                    Toast.LENGTH_SHORT).show();
//        }
    }

    public void module1Jump(View view) {
        HGRouter.getInstance().build("/module1/test").withString("msg","从Module2").navigation(this);
    }

}
