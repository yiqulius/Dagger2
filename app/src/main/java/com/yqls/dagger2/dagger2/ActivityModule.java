package com.yqls.dagger2.dagger2;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 *
 * 下层Module类
 */
@Module
public class ActivityModule {

    @PersonForContext
    @Provides
    @PerActivity  // 添加标记，声明对象单例
    Person providePersonContext(Context context){
        //　此方法需要Context 对象
        return new Person(context);
    }


    @PersonForName  // 通过name创建Person 对象
    @Provides
    Person providePersonName(){
        //　此方法需要Context 对象
        return new Person("123");
    }
}
