package com.example.sergiomoral.iphonedroid.presentation.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.example.sergiomoral.iphonedroid.iphoneDroidApp;
import com.example.sergiomoral.iphonedroid.presentation.di.component.AppComponent;
import com.example.sergiomoral.iphonedroid.presentation.di.modules.ActivityModule;
import com.example.sergiomoral.iphonedroid.presentation.dialogs.base.DialogManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public abstract class BaseActivity extends Activity implements BaseView {

    @Inject
    DialogManager mDialogManager;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        int layoutId = getLayoutId();
        if (layoutId != 0) {
            setContentView(layoutId);
            ButterKnife.bind(this);
        }

        initInjector();
        attachViewToPresenter();
        initUI();
    }

    @Override
    public void showLoading() {
        mDialogManager.showLoading();
    }

    @Override
    public void hideLoading() {
        mDialogManager.hideLoading();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected AppComponent getAppComponent() {
        return ((iphoneDroidApp) getApplication()).getAppComponent();
    }


    protected abstract void attachViewToPresenter();

    protected abstract void initInjector();

    protected abstract void initUI();

    public abstract int getLayoutId();
}
