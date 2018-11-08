package com.example.sergiomoral.iphonedroid.presentation.ui.splash;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;
import com.example.sergiomoral.iphonedroid.presentation.di.component.DaggerActivitycomponent;
import com.example.sergiomoral.iphonedroid.presentation.ui.main.MainActivity;
import com.example.sergiomoral.iphonedroid.R;
import com.example.sergiomoral.iphonedroid.presentation.base.BaseActivity;
import com.example.sergiomoral.iphonedroid.presentation.presenter.splash.SplashPresenter;
import com.example.sergiomoral.iphonedroid.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashView {

    @Inject
    SplashPresenter mPresenter;

    ArrayList<PublicRepositories> publicRepositoriesArrayList;
    int lastID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void attachViewToPresenter() {
        mPresenter.attachView(this);
    }


    @Override
    protected void initInjector() {
        DaggerActivitycomponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build().inject(this);
    }

    @Override
    protected void initUI() {
        publicRepositoriesArrayList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(SplashActivity.this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(SplashActivity.this, new String[]{Manifest.permission.INTERNET}, Constants.INTERNET_PERMISSION_CODE);
        } else if (publicRepositoriesArrayList.size() == 0) {
            mPresenter.getPublicRepositories(lastID);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash_screen;
    }

    @Override
    public void showPublicrepositories(List<PublicRepositories> publicRepositoriesList) {
        gottoMainActivity(publicRepositoriesList);
    }

    @Override
    public void gottoMainActivity(List<PublicRepositories> publicRepositoriesList) {
        publicRepositoriesArrayList.addAll(publicRepositoriesList);
        MainActivity.open(SplashActivity.this, publicRepositoriesArrayList);
        finish();
    }
}
