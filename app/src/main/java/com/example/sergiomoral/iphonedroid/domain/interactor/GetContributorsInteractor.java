package com.example.sergiomoral.iphonedroid.domain.interactor;

import com.example.sergiomoral.iphonedroid.domain.entities.Contributor;
import com.example.sergiomoral.iphonedroid.domain.executor.InteractorExecutor;
import com.example.sergiomoral.iphonedroid.domain.executor.MainThreadExecutor;
import com.example.sergiomoral.iphonedroid.domain.repository.Repository;

import java.util.List;

import javax.inject.Inject;

public class GetContributorsInteractor extends BaseInteractor {

    private Callback<List<Contributor>> mCallback;
    private Repository mRepository;
    private String mUserName;
    private String mProjectName;

    @Inject
    public GetContributorsInteractor(InteractorExecutor mInteractorExecutor, MainThreadExecutor mMainThreadExecutor, Repository repository) {
        super(mInteractorExecutor, mMainThreadExecutor);
        mRepository = repository;
    }

    public void execute(String userName, String projectName, Callback<List<Contributor>> callback) {
        mCallback = callback;

        mUserName = userName;
        mProjectName = projectName;

        executeInBackground();
    }

    @Override
    public void run() {
        try{
            List<Contributor> contributors = mRepository.getContributors(mUserName, mProjectName);
            notifySuccess(contributors);
        } catch (Exception exception){
            notifyError(exception);
        }
    }

    private void notifySuccess(final List<Contributor> contributorsList) {

        executeInMainThread(new Runnable() {
            @Override
            public void run() {
                if (mCallback != null) {
                    mCallback.onSuccess(contributorsList);
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
