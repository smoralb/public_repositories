package com.example.sergiomoral.iphonedroid.domain.interactor;

import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;
import com.example.sergiomoral.iphonedroid.domain.executor.InteractorExecutor;
import com.example.sergiomoral.iphonedroid.domain.executor.MainThreadExecutor;
import com.example.sergiomoral.iphonedroid.domain.repository.Repository;

import java.util.List;

import javax.inject.Inject;


public class GetPublicRepositoriesInteractor extends BaseInteractor {

    private Callback<List<PublicRepositories>> mCallback;
    private Repository mRepository;
    int mLastID;

    @Inject
    public GetPublicRepositoriesInteractor(InteractorExecutor mInteractorExecutor, MainThreadExecutor mMainThreadExecutor,
                                           Repository repository) {
        super(mInteractorExecutor, mMainThreadExecutor);
        mRepository = repository;
    }


    public void execute(int lastID, Callback<List<PublicRepositories>> callback) {

        mCallback = callback;

        mLastID = lastID;

        executeInBackground();
    }

    @Override
    public void run() {
        try {
            List<PublicRepositories> publicRepositories = mRepository.getPublicrepositories(mLastID);
            notifySuccess(publicRepositories);
        } catch (Exception e) {
            notifyError(e);
        }
    }

    private void notifySuccess(final List<PublicRepositories> publicRepositoriesList) {

        executeInMainThread(new Runnable() {
            @Override
            public void run() {
                if (mCallback != null) {
                    mCallback.onSuccess(publicRepositoriesList);
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
