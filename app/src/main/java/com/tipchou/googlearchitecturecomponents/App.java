package com.tipchou.googlearchitecturecomponents;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by 邵励治 on 2018/4/6.
 * Perfect Code
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AVOSCloud.initialize(this, "TDJUy79LG3JzSqVw7Hj1emIr-gzGzoHsz", "P1wJ6vfje0bVezeeio4eqCJ7");
    }
}
