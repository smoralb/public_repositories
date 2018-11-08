package com.example.sergiomoral.iphonedroid.domain.mock;

import com.example.sergiomoral.iphonedroid.domain.executor.MainThreadExecutor;

public class MainThreadExecutorMock implements MainThreadExecutor {

    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
