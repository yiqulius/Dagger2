package com.yqls.dagger2.dagger2;

import android.content.Context;
import android.util.Log;

public class Person {

    private Context mContext;

    public Person(Context context){
        mContext = context;
        Log.i("dagger","create");
    }

    public Person(String name){
        Log.i("dagger",name);
    }
}
