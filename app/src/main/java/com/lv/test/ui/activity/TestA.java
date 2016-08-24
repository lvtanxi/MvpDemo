package com.lv.test.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lv.test.R;
import com.lv.test.presenter.UserPresenter;
import com.lv.test.ui.IView.IUserView;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * User: 吕勇
 * Date: 2016-08-24
 * Time: 15:36
 * Description:
 */
public class TestA extends MVPBaseActvity<IUserView,UserPresenter> implements IUserView{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPwd() {
        return null;
    }

    @Override
    protected UserPresenter createPresenter() {
        return new UserPresenter();
    }
    @OnClick(R.id.login)
    public void onClick() {
        mPresenter.validateUser();
    }
}
