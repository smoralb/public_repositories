package com.example.sergiomoral.iphonedroid.presentation.di.component;

import android.app.Activity;
import android.content.Context;

import com.example.sergiomoral.iphonedroid.presentation.ui.details.DetailsActivity;
import com.example.sergiomoral.iphonedroid.presentation.ui.main.MainActivity;
import com.example.sergiomoral.iphonedroid.presentation.ui.splash.SplashActivity;
import com.example.sergiomoral.iphonedroid.presentation.di.modules.ActivityModule;
import com.example.sergiomoral.iphonedroid.presentation.di.qualifiers.PerActivity;

import javax.inject.Singleton;

import dagger.Component;


@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface Activitycomponent {

    Activity activity();

    Context context();

    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);

    void inject(DetailsActivity detailsActivity);
}
