package com.yqls.dagger2.dagger2;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context mContext;

    public AppModule(Context context){
        mContext = context;
    }

    @Provides
    @PerApp  // 添加该标记表明该方法只产生一个实例
    Context providesContext(){
        // 提供上下文对象
        return mContext;
    }

}
