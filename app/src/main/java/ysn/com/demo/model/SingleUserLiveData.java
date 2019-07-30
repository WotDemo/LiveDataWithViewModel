package ysn.com.demo.model;

import android.arch.lifecycle.LiveData;

import ysn.com.demo.bean.User;

/**
 * @Author yangsanning
 * @ClassName SingleUserLiveData
 * @Description 一句话概括作用
 * @Date 2019/7/30
 * @History 2019/7/30 author: description:
 */
public class SingleUserLiveData extends LiveData<User> {

    private static SingleUserLiveData instance;

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

    @Override
    public void postValue(User value) {
        super.postValue(value);
    }

    @Override
    public void setValue(User value) {
        super.setValue(value);
    }
}
