package com.yqls.dagger2.dagger2;

import dagger.Component;

/**
 *  子的Component
 */
@PerActivity  // ActivityModule 中使用了该标记
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    // 注入
    void inject(MainActivity activity);
}
