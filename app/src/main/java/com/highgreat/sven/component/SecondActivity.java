package com.highgreat.sven.component;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.highgreat.sven.base.TestService;
import com.highgreat.sven.component.parcelable.TestParcelable;
import com.highgreat.sven.router_annotation.Extra;
import com.highgreat.sven.router_annotation.Route;
import com.highgreat.sven.router_core.HGRouter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Route(path = "/main/test") //标志
public class SecondActivity extends Activity {

    @Extra
    String a;
    @Extra
    int b;
    @Extra
    short c;
    @Extra
    long d;
    @Extra
    float e;
    @Extra
    double f;
    @Extra
    byte g;
    @Extra
    boolean h;
    @Extra
    char i;


    @Extra
    String[] aa;
    @Extra
    int[] bb;
    @Extra
    short[] cc;
    @Extra
    long[] dd;
    @Extra
    float[] ee;
    @Extra
    double[] ff;
    @Extra
    byte[] gg;
    @Extra
    boolean[] hh;
    @Extra
    char[] ii;

    @Extra
    TestParcelable j;
    @Extra
    TestParcelable[] jj;


    @Extra
    List<TestParcelable> k1;
    @Extra
    ArrayList<TestParcelable> k2;

    @Extra
    List<String> k3;

    @Extra
    List<Integer> k4;

    @Extra(name = "hhhhhh")
    int test;

    @Extra(name = "/main/service1")
    TestService testService1;
    @Extra(name = "/main/service2")
    TestService testService2;
    @Extra(name = "/module1/service")
    TestService testService3;
    @Extra(name = "/module2/service")
    TestService testService4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        HGRouter.getInstance().inject(this);
        Log.e("Second", toString());

        testService1.test();
        testService2.test();
        testService3.test();
        testService4.test();
    }

    @Override
    public void onBackPressed() {
        setResult(200);
        super.onBackPressed();
    }

    @Override
    public String toString() {
        return "SecondActivity{" +
                "a='" + a + '\'' +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                ", f=" + f +
                ", g=" + g +
                ", h=" + h +
                ", i=" + i +
                ", aa=" + Arrays.toString(aa) +
                ", bb=" + Arrays.toString(bb) +
                ", cc=" + Arrays.toString(cc) +
                ", dd=" + Arrays.toString(dd) +
                ", ee=" + Arrays.toString(ee) +
                ", ff=" + Arrays.toString(ff) +
                ", gg=" + Arrays.toString(gg) +
                ", hh=" + Arrays.toString(hh) +
                ", ii=" + Arrays.toString(ii) +
                ", j=" + j +
                ", jj=" + Arrays.toString(jj) +
                ", k1=" + k1 +
                ", k2=" + k2 +
                ", k3=" + k3 +
                ", k4=" + k4 +
                '}';
    }

}
