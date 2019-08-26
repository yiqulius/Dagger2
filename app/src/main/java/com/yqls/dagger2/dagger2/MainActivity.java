package com.yqls.dagger2.dagger2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yqls.dagger2.App;
import com.yqls.dagger2.R;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;

public class MainActivity extends AppCompatActivity{

    @PersonForContext // 标记
    @Inject
    Lazy<Person> lazyPerson; // 注入Lazy元素


    @PersonForName // 标记
    @Inject
    Provider<Person> providerPerson; // 注入Provider


    /**
     * 不使用静态的，因为该Component只是针对于该Activity，而不是全局的
     */
    ActivityComponent  activityComponent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        activityComponent = DaggerActivityComponent.builder()
                .appComponent(App.appComponent)  // 添加了全局的AppComponent组件
                .activityModule(new ActivityModule())
                .build();


        activityComponent.inject(this);


        Person person = lazyPerson.get();// 调用该方法时才会去创建Person,以后每次调用获取的是同一个对象


        // 调用该方法时才回去创建Person1，以后每次调用都会重新加载Module中的具体方法，根据Module中的实现，可能相同，可能不相同。
        Person person1 = providerPerson.get();

     /*   // 构造桥梁对象
        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();

        //注入
        component.inject(this);*/

        // 依赖对象　Component
//        AppComponent appCom = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
//
//        // 子类依赖对象 ，并注入
//        DaggerActivityComponent.builder()
//                .appComponent(appCom)
//                .activityModule(new ActivityModule())
//                .build()
//                .inject(this);
    }


    public void go(View view){
        Intent intent = new Intent(this,Main2Activity.class);

        startActivity(intent);
    }
}
