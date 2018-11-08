package com.example.sergiomoral.iphonedroid.presentation.executor;

import android.support.annotation.NonNull;

import com.arasthel.asyncjob.AsyncJob;
import com.example.sergiomoral.iphonedroid.domain.executor.InteractorExecutor;
import com.example.sergiomoral.iphonedroid.domain.interactor.BaseInteractor;

import java.io.Serializable;

import javax.inject.Inject;

public class InteractorExecutorImp implements InteractorExecutor, Serializable {

    @Inject
    public InteractorExecutorImp() {

    }

    @Override
    public void execute(@NonNull final BaseInteractor baseInteractor) {
        AsyncJob.doInBackground(new AsyncJob.OnBackgroundJob() {
            @Override
            public void doOnBackground() {
                baseInteractor.run();
            }
        });
    }
}
