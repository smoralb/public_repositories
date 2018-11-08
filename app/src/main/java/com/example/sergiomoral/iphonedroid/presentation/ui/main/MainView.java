package com.example.sergiomoral.iphonedroid.presentation.ui.main;

import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;

import java.util.ArrayList;

public interface MainView {

    void setLayout(int emptyLayout);

    void setVisibility(int drawerVisibility);

    void filterList(String data);

    void updataData(ArrayList<PublicRepositories> publicList);

    void hideKeyboard();

    void loadingView();

    void setMoreUsers(ArrayList<PublicRepositories> publicRepositories);
}
