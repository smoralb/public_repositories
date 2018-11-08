package com.example.sergiomoral.iphonedroid.presentation.ui.splash;

import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;

import java.util.List;

public interface SplashView {

    void gottoMainActivity(List<PublicRepositories> publicRepositoriesList);

    void showPublicrepositories(List<PublicRepositories> publicRepositoriesList);

    void hideLoading();
}
