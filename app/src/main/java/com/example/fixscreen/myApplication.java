package com.example.fixscreen;

import android.app.Application;

//import com.petterp.floatingx.FloatingX;
//import com.petterp.floatingx.assist.helper.AppHelper;

public class myApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        AppHelper helper = AppHelper.builder()
//                .setLayout(R.layout.item_floating)
//                .enableFx()
//                .build();
//        FloatingX.install(helper);
    }
}
