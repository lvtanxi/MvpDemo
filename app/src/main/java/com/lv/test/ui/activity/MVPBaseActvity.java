package com.lv.test.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.lv.test.presenter.BasePresenter;
import com.lv.test.ui.IView.IBaseView;

/**
 * User: 吕勇
 * Date: 2016-08-24
 * Time: 15:08
 * Description: 基类 V 表示IView的接口类型；T 表示继承BasePresenter的Presenter类型
 */
public abstract class MVPBaseActvity<V,T extends BasePresenter<V>> extends AppCompatActivity implements IBaseView {
    protected T mPresenter;
    protected ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化Presenter
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
        progressDialog=new ProgressDialog(this);
    }

    /**
     * 初始化 Presenter
     * @return 继承BasePresenter的Presenter
     */
    protected abstract T createPresenter();

    @Override
    public void showLoadingView() {
        progressDialog.show();
    }

    @Override
    public void hideLoadingView() {
        progressDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        //解除Presenter 与 IView 的关系
        if (null != mPresenter)
            mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void toastError(String message) {
        if(!TextUtils.isEmpty(message))
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
