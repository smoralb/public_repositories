package com.example.sergiomoral.iphonedroid.domain.interactor;

import com.example.sergiomoral.iphonedroid.domain.entities.Fork;
import com.example.sergiomoral.iphonedroid.domain.executor.InteractorExecutor;
import com.example.sergiomoral.iphonedroid.domain.executor.MainThreadExecutor;
import com.example.sergiomoral.iphonedroid.domain.repository.Repository;

import java.util.List;

import javax.inject.Inject;

public class GetForksInteractor extends BaseInteractor {

    private Callback<List<Fork>> mCallback;
    private Repository mRepository;
    private String mUserName;
    private String mProjectName;

    @Inject
    public GetForksInteractor(InteractorExecutor mInteractorExecutor, MainThreadExecutor mMainThreadExecutor, Repository repository) {
        super(mInteractorExecutor, mMainThreadExecutor);
        mRepository = repository;
    }

    public void execute(String userName, String projectName, Callback<List<Fork>> callback) {
        mCallback = callback;

        mUserName = userName;
        mProjectName = projectName;

        executeInBackground();
    }

    @Override
    public void run() {
        try {
            List<Fork> forks = mRepository.getForks(mUserName, mProjectName);
            notifySuccess(forks);
        } catch (Exception exception) {
            notifyError(exception);
        }
    }

    private void notifySuccess(final List<Fork> forksList) {

        executeInMainThread(new Runnable() {
            @Override
            public void run() {
                if (mCallback != null) {
                    mCallback.onSuccess(forksList);
                }
            }
        });
    }

    private void notifyError(final Exception exception) {

        executeInMainThread(new Runnable() {
            @Override
            public void run() {
                if (mCallback != null) {
                    mCallback.onError(exception);
                }
            }
        });
    }

}
