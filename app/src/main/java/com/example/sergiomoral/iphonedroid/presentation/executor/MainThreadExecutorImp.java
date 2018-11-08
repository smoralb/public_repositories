package com.example.sergiomoral.iphonedroid.presentation.executor;

import android.os.Handler;

import com.example.sergiomoral.iphonedroid.domain.executor.MainThreadExecutor;

import java.io.Serializable;

import javax.inject.Inject;

public class MainThreadExecutorImp implements MainThreadExecutor, Serializable {

    private transient Handler mHandler;

    @Inject
    public MainThreadExecutorImp(Handler handler) {
        mHandler = handler;
    }

    @Override
    public void execute(Runnable runnable) {
        mHandler.post(runnable);
    }
}
