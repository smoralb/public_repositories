package com.example.sergiomoral.iphonedroid.presentation.presenter.details;

import com.example.sergiomoral.iphonedroid.domain.entities.Contributor;
import com.example.sergiomoral.iphonedroid.domain.entities.Fork;
import com.example.sergiomoral.iphonedroid.domain.entities.Issue;
import com.example.sergiomoral.iphonedroid.domain.interactor.BaseInteractor;
import com.example.sergiomoral.iphonedroid.domain.interactor.GetContributorsInteractor;
import com.example.sergiomoral.iphonedroid.domain.interactor.GetForksInteractor;
import com.example.sergiomoral.iphonedroid.domain.interactor.GetIssuesInteractor;
import com.example.sergiomoral.iphonedroid.presentation.dialogs.base.DialogManager;
import com.example.sergiomoral.iphonedroid.presentation.presenter.Presenter;
import com.example.sergiomoral.iphonedroid.presentation.ui.details.DetailsView;

import java.util.List;

import javax.inject.Inject;

public class DetailsPresenter implements Presenter<DetailsView> {

    @Inject
    DialogManager mDialogManager;

    private GetContributorsInteractor mGetContributorsInteractor;
    private GetForksInteractor mGetForksInteractor;
    private GetIssuesInteractor mGetIssuesInteractor;
    private DetailsView mView;

    @Inject
    public DetailsPresenter(GetContributorsInteractor getContributorsInteractor, GetForksInteractor getForksInteractor, GetIssuesInteractor getIssuesInteractor) {
        this.mGetContributorsInteractor = getContributorsInteractor;
        this.mGetForksInteractor = getForksInteractor;
        this.mGetIssuesInteractor = getIssuesInteractor;
    }

    @Override
    public void attachView(DetailsView view) {
        mView = view;
    }

    public void getContributors(String userName, String projectName) {
        mGetContributorsInteractor.execute(userName, projectName, new BaseInteractor.Callback<List<Contributor>>() {
            @Override
            public void onSuccess(List<Contributor> response) {
                mView.setContributors(response);
            }

            @Override
            public void onError(Exception exception) {
                mView.hideLoading();
                mDialogManager.showErrorMessage();
            }
        });
    }

    public void getForks(String userName, String projectName) {
        mGetForksInteractor.execute(userName, projectName, new BaseInteractor.Callback<List<Fork>>() {
            @Override
            public void onSuccess(List<Fork> response) {
                mView.setForks(response);
            }

            @Override
            public void onError(Exception exception) {
                mView.hideLoading();
                mDialogManager.showErrorMessage();
            }
        });
    }

    public void getIssues(String userName, String projectName) {
        mGetIssuesInteractor.execute(userName, projectName, new BaseInteractor.Callback<Issue>() {
            @Override
            public void onSuccess(Issue response) {
                mView.setIssues(String.valueOf(response.getNumber()));
            }

            @Override
            public void onError(Exception exception) {
                mView.hideLoading();
                mDialogManager.showErrorMessage();
            }
        });
    }
}
