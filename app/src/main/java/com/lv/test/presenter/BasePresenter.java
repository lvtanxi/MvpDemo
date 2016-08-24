package com.lv.test.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * User: 吕勇
 * Date: 2016-08-24
 * Time: 15:00
 * Description:Presenter层的基类 T IView  接口
 */
public abstract class BasePresenter<T> {

    protected Reference<T> mReference;

    /**
     *绑定IView实例
     * @param view IView实例
     */
    public void attachView(T view) {
        mReference = new WeakReference<T>(view);
    }

    /**
     * 获取IView实例
     */
    protected T getView() {
        if (null == mReference)
            return null;
        return mReference.get();
    }

    /**
     * 判断IView实例是否还存在
     */
    public boolean isViewAttached() {
        return mReference != null && mReference.get() != null;
    }

    /**
     * 解除Presenter 与 IView的关系
     */
    public void detachView() {
        if (null != mReference) {
            mReference.clear();
            mReference = null;
        }
    }

}
