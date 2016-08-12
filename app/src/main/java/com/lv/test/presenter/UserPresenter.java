package com.lv.test.presenter;

import android.text.TextUtils;

import com.lv.test.model.User;
import com.lv.test.ui.IView.IUserView;

import io.paperdb.Paper;

/**
 * User: 吕勇
 * Date: 2016-04-16
 * Time: 10:20
 * Description:
 */
public class UserPresenter {
    private IUserView iUserView;

    public UserPresenter(IUserView iUserView) {
        this.iUserView = iUserView;
    }
    public void validateUser(){
        String userName = iUserView.getUserName();
        if(TextUtils.isEmpty(userName)){
            iUserView.notifyDialog("我是你爸爸");
            return;
        }
        String pwd = iUserView.getPwd();
        if(TextUtils.isEmpty(pwd)){
            iUserView.showToast("她是你妈妈");
            return;
        }
        User user=new User();
        user.setName(userName);
        user.setPwd(pwd);
        Paper.book().write("user", user);
        iUserView.startActivity();
    }
}
