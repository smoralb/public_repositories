package com.example.sergiomoral.iphonedroid;

import android.app.Application;

import com.example.sergiomoral.iphonedroid.presentation.di.component.AppComponent;
import com.example.sergiomoral.iphonedroid.presentation.di.component.DaggerAppComponent;
import com.example.sergiomoral.iphonedroid.presentation.di.modules.AppModule;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class iphoneDroidApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initInjector();
        initCalligraphy();
    }

    private void initInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    private void initCalligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
