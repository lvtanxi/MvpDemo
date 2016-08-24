package com.lv.test.presenter;

import android.util.Log;

import com.lv.test.ui.IView.IUserView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * User: 吕勇
 * Date: 2016-04-16
 * Time: 10:20
 * Description:
 */
public class UserPresenter extends BasePresenter<IUserView> {

    public void validateUser() {
        if (isViewAttached())
            getView().showLoadingView();
        getView().getPwd();
        getView().getUserName();
        RequestParams requestParams = new RequestParams("http://101.204.247.72:10003/wmapp-server/app/getNewest");
        requestParams.addBodyParameter("app_type", "1");
        requestParams.setAsJsonContent(true);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("UserPresenter", result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                if (isViewAttached())
                    getView().toastError(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                if (isViewAttached())
                    getView().hideLoadingView();
            }

            @Override
            public void onFinished() {
                if (isViewAttached())
                    getView().hideLoadingView();
            }
        });
    }

}
