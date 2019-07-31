package ysn.com.demo.model;

import android.arch.lifecycle.LiveData;

import ysn.com.demo.bean.User;

/**
 * @Author yangsanning
 * @ClassName SingleUserLiveData
 * @Description 单例
 * @Date 2019/7/30
 * @History 2019/7/30 author: description:
 */
public class SingleUserLiveData extends LiveData<User> {

    private static SingleUserLiveData instance;

    /**
     * 采用单例的目的: 让多个Activity或者Fragment共享一个实例
     */
    public static synchronized SingleUserLiveData get() {
        if (instance == null) {
            synchronized (SingleUserLiveData.class) {
                if (instance == null) {
                    instance = new SingleUserLiveData();
                }
            }
        }
        return instance;
    }

    /**
     * 子线程调用post
     */
    @Override
    public void postValue(User value) {
        super.postValue(value);
    }

    /**
     * 更新LiveData数据，并通知处于活动状态的观察者
     */
    @Override
    public void setValue(User value) {
        super.setValue(value);
    }

    /**
     * 观察者数量从0变为了1时调用
     */
    @Override
    protected void onActive() {
    }

    /**
     * 观察者数量变为了0时调用
     */
    @Override
    protected void onInactive() {
    }
}
