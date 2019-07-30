package ysn.com.demo.model;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import ysn.com.demo.bean.User;

/**
 * @Author yangsanning
 * @ClassName SingleUserModel
 * @Description 一句话概括作用
 * @Date 2019/7/30
 * @History 2019/7/30 author: description:
 */
public class SingleUserModel extends ViewModel {

    private SingleUserLiveData userLiveData = SingleUserLiveData.get();;

    public static SingleUserModel get(@NonNull FragmentActivity activity) {
        return ViewModelProviders.of(activity).get(SingleUserModel.class);
    }

    public SingleUserModel observe(@NonNull LifecycleOwner owner, @NonNull Observer<User> observer) {
        userLiveData.observe(owner, observer);
        return this;
    }

    /**
     * 子线程调用post
     */
    public void postValue(User user) {
        userLiveData.postValue(user);
    }

    public void setValue(User user) {
        userLiveData.setValue(user);
    }

    /**
     * 当Activity被销毁时，Framework会调用ViewModel的onCleared()
     */
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("test", "SingleUserModel onCleared()");
    }
}