package com.example.sergiomoral.iphonedroid.presentation.di.component;

import android.app.Application;

import com.example.sergiomoral.iphonedroid.domain.executor.InteractorExecutor;
import com.example.sergiomoral.iphonedroid.domain.executor.MainThreadExecutor;
import com.example.sergiomoral.iphonedroid.domain.repository.Repository;
import com.example.sergiomoral.iphonedroid.domain.repository.datasource.NetworkDataSource;
import com.example.sergiomoral.iphonedroid.presentation.di.modules.ActivityModule;
import com.example.sergiomoral.iphonedroid.presentation.di.modules.ApiModule;
import com.example.sergiomoral.iphonedroid.presentation.di.modules.AppModule;
import com.example.sergiomoral.iphonedroid.presentation.di.modules.DataModule;
import com.example.sergiomoral.iphonedroid.presentation.di.modules.ExecutorModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ActivityModule.class, ApiModule.class, ExecutorModule.class, DataModule.class})
public interface AppComponent {

    Application app();

    NetworkDataSource networkDataSource();

    InteractorExecutor interactorExecutor();

    MainThreadExecutor mainThreadExecutor();

    Repository repository();
}
