package com.luliang.devmvp.mvp.base;

import com.luliang.devmvp.api.DevMapApi;
import com.luliang.devmvp.api.DevMvpService;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Liang_Lu on 2017/12/21.
 */

public abstract class BaseModel {


   public CompositeDisposable mDisposable = new CompositeDisposable();


    public DevMvpService apiService() {
        return DevMapApi.createApi().create(DevMvpService.class);
    }


    protected void addRxDisposable(Disposable disposable) {
        mDisposable.add(disposable);
    }


    public void onDestroy() {
        if (mDisposable != null) {
            mDisposable.isDisposed();
            mDisposable.clear();
        }
    }


}