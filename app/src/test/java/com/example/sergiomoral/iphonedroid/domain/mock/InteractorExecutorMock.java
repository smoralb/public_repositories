package com.example.sergiomoral.iphonedroid.domain.mock;

import com.example.sergiomoral.iphonedroid.domain.executor.InteractorExecutor;
import com.example.sergiomoral.iphonedroid.domain.interactor.BaseInteractor;

public class InteractorExecutorMock implements InteractorExecutor {

    @Override
    public void execute(BaseInteractor baseInteractor) {
        baseInteractor.run();
    }
}
