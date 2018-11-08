package com.example.sergiomoral.iphonedroid.domain.interactor;

import com.example.sergiomoral.iphonedroid.domain.entities.Issue;
import com.example.sergiomoral.iphonedroid.domain.executor.InteractorExecutor;
import com.example.sergiomoral.iphonedroid.domain.executor.MainThreadExecutor;
import com.example.sergiomoral.iphonedroid.domain.repository.Repository;

import javax.inject.Inject;

public class GetIssuesInteractor extends BaseInteractor {

    private Callback<Issue> mCallback;
    private Repository mRepository;
    private String mUserName;
    private String mProjectName;

    @Inject
    public GetIssuesInteractor(InteractorExecutor mInteractorExecutor, MainThreadExecutor mMainThreadExecutor, Repository repository) {
        super(mInteractorExecutor, mMainThreadExecutor);
        mRepository = repository;
    }

    public void execute(String userName, String projectName, Callback<Issue> callback) {
        mCallback = callback;

        mUserName = userName;
        mProjectName = projectName;

        executeInBackground();
    }

    @Override
    public void run() {
        try {
            Issue issues = mRepository.getIssues(mUserName, mProjectName);
            notifySuccess(issues);
        } catch (Exception exception) {
            notifyError(exception);
        }
    }

    private void notifySuccess(final Issue issues) {

        executeInMainThread(new Runnable() {
            @Override
            public void run() {
                if (mCallback != null) {
                    mCallback.onSuccess(issues);
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
