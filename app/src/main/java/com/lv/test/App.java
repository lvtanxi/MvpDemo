package com.lv.test;

import android.app.Application;

import com.lv.test.ui.IView.IBaseView;

import org.xutils.x;

import io.paperdb.Paper;

/**
 * User: 吕勇
 * Date: 2016-04-16
 * Time: 10:18
 * Description:
 */
public class App extends Application{
    private static App mApp;
    private IBaseView mBaseView;

    public void setBaseView(IBaseView baseView) {
        mBaseView = baseView;
    }
    public static synchronized App getApp(){

        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp=this;
        Paper.init(this);
        x.Ext.init(this);
    }
}
