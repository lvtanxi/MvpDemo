package com.lv.test.ui.IView;

/**
 * User: 吕勇
 * Date: 2016-03-17
 * Time: 09:38
 * Description:显示加载框的接口
 */
public interface IBaseView {

    void showLoadingView();

    void hideLoadingView();

    void toastError(String message);

}