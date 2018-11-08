package com.example.sergiomoral.iphonedroid.presentation.di.modules;

import android.app.Activity;
import android.content.Context;

import com.example.sergiomoral.iphonedroid.presentation.di.qualifiers.PerActivity;
import com.example.sergiomoral.iphonedroid.presentation.dialogs.base.DialogManager;
import com.example.sergiomoral.iphonedroid.presentation.dialogs.base.DialogManagerImp;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @PerActivity
    public Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    public DialogManager provideDialogManager(DialogManagerImp dialogManagerImp) {
        return dialogManagerImp;
    }
}
