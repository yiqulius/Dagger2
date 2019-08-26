package com.yqls.dagger2;

import android.app.Application;

import com.yqls.dagger2.dagger2.AppComponent;
import com.yqls.dagger2.dagger2.AppModule;
import com.yqls.dagger2.dagger2.DaggerAppComponent;

public class App extends Application {

    // 为什么可以使用静态, 因为该AppComponent对象的生命周期是整个App
    public static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        // 实例化
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

    }
}
