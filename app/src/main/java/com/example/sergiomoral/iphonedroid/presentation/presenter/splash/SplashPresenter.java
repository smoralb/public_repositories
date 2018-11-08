package com.example.sergiomoral.iphonedroid.presentation.presenter.splash;

import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;
import com.example.sergiomoral.iphonedroid.domain.interactor.BaseInteractor;
import com.example.sergiomoral.iphonedroid.presentation.dialogs.base.DialogManager;
import com.example.sergiomoral.iphonedroid.domain.interactor.GetPublicRepositoriesInteractor;
import com.example.sergiomoral.iphonedroid.presentation.presenter.Presenter;
import com.example.sergiomoral.iphonedroid.presentation.ui.splash.SplashView;

import java.util.List;

import javax.inject.Inject;

public class SplashPresenter implements Presenter<SplashView> {

    private SplashView mView;
    private GetPublicRepositoriesInteractor mGetPublicRepositoriesInteractor;

    @Inject
    DialogManager mDialogManager;

    @Inject
    public SplashPresenter(GetPublicRepositoriesInteractor mGetPublicRepositoriesInteractor) {
        this.mGetPublicRepositoriesInteractor = mGetPublicRepositoriesInteractor;
    }

    @Override
    public void attachView(SplashView view) {
        mView = view;
    }

    public void getPublicRepositories(int lastID) {

        mGetPublicRepositoriesInteractor.execute(lastID, new BaseInteractor.Callback<List<PublicRepositories>>() {
            @Override
            public void onSuccess(List<PublicRepositories> response) {
                mView.showPublicrepositories(response);
            }

            @Override
            public void onError(Exception exception) {
                mView.hideLoading();
                mDialogManager.showErrorMessage();
            }
        });
    }

}
