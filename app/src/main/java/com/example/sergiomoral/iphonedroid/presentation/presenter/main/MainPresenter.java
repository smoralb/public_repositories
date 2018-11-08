package com.example.sergiomoral.iphonedroid.presentation.presenter.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;
import com.example.sergiomoral.iphonedroid.domain.interactor.BaseInteractor;
import com.example.sergiomoral.iphonedroid.domain.interactor.GetPublicRepositoriesInteractor;
import com.example.sergiomoral.iphonedroid.presentation.dialogs.base.DialogManager;
import com.example.sergiomoral.iphonedroid.presentation.presenter.Presenter;
import com.example.sergiomoral.iphonedroid.presentation.ui.main.MainView;
import com.example.sergiomoral.iphonedroid.utils.Utils;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainPresenter implements Presenter<MainView> {

    @Inject
    DialogManager mDialogManager;

    MainView mView;
    private GetPublicRepositoriesInteractor mGetPublicRepositoriesInteractor;

    @Inject
    public MainPresenter(GetPublicRepositoriesInteractor mGetPublicRepositoriesInteractor) {
        this.mGetPublicRepositoriesInteractor = mGetPublicRepositoriesInteractor;
    }

    @Override
    public void attachView(MainView view) {
        mView = view;
    }

    public void viewVisibility(int visibility) {
        mView.setVisibility(Utils.getDrawerVisibility(visibility));
    }

    public void filterData(EditText filter) {
        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mView.filterList(s.toString());
            }
        });
    }

    public void filterText(ArrayList<PublicRepositories> arrayToFilter, String data) {
        ArrayList<PublicRepositories> publicList = new ArrayList<>();

        for (PublicRepositories item : arrayToFilter) {
            if (item.getOwner().getUserName().toLowerCase().contains(data)) {
                publicList.add(item);
            }
        }
        mView.updataData(publicList);
    }

    public void keyBoardListener(EditText filterButton) {
        filterButton.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    mView.hideKeyboard();
                    return true;
                }
                return false;
            }
        });
    }

    public void recyclerViewListener(RecyclerView recyclerView, final ArrayList<PublicRepositories> publicRepositories) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1)) {
                    getmoreUsers(publicRepositories);
                }
            }
        });
    }

    private void getmoreUsers(final ArrayList<PublicRepositories> publicRepositories) {
        mView.loadingView();
        if (publicRepositories != null && publicRepositories.size() > 0) {
            mGetPublicRepositoriesInteractor.execute(publicRepositories.get(publicRepositories.size() - 1).getId(), new BaseInteractor.Callback<List<PublicRepositories>>() {
                @Override
                public void onSuccess(List<PublicRepositories> response) {
                    publicRepositories.addAll(response);
                    mView.setMoreUsers(publicRepositories);
                }

                @Override
                public void onError(Exception exception) {
                    mView.loadingView();
                    mDialogManager.showErrorMessage();
                }
            });
        }
    }
}
