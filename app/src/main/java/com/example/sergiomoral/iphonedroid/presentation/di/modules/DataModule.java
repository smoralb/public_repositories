package com.example.sergiomoral.iphonedroid.presentation.di.modules;

import com.example.sergiomoral.iphonedroid.data.network.models.ApiContributor;
import com.example.sergiomoral.iphonedroid.data.network.models.ApiFork;
import com.example.sergiomoral.iphonedroid.data.network.models.ApiIssue;
import com.example.sergiomoral.iphonedroid.data.network.models.ApiOwner;
import com.example.sergiomoral.iphonedroid.data.network.models.ApiPublicRepositories;
import com.example.sergiomoral.iphonedroid.data.network.mapper.ApiContributorMapper;
import com.example.sergiomoral.iphonedroid.data.network.mapper.ApiForkMapper;
import com.example.sergiomoral.iphonedroid.data.network.mapper.ApiIssueMapper;
import com.example.sergiomoral.iphonedroid.data.network.mapper.ApiOwnerMapper;
import com.example.sergiomoral.iphonedroid.data.network.mapper.ApiPublicRepositoriesMapper;
import com.example.sergiomoral.iphonedroid.domain.entities.Contributor;
import com.example.sergiomoral.iphonedroid.domain.entities.Fork;
import com.example.sergiomoral.iphonedroid.domain.entities.Issue;
import com.example.sergiomoral.iphonedroid.domain.entities.Owner;
import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;
import com.example.sergiomoral.iphonedroid.domain.mappers.ListMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    ListMapper<ApiContributor, Contributor> providesApiContributorMapper(ApiContributorMapper apiContributorMapper) {
        return new ListMapper<>(apiContributorMapper);
    }

    @Provides
    @Singleton
    ListMapper<ApiFork, Fork> providesApiForkMapper(ApiForkMapper apiForkMapper) {
        return new ListMapper<>(apiForkMapper);
    }

    @Provides
    @Singleton
    ListMapper<ApiIssue, Issue> providesApiIssueMapper(ApiIssueMapper apiIssueMapper) {
        return new ListMapper<>(apiIssueMapper);
    }

    @Provides
    @Singleton
    ListMapper<ApiOwner, Owner> providesApiOwnerMapper(ApiOwnerMapper apiOwnerMapper) {
        return new ListMapper<>(apiOwnerMapper);
    }

    @Provides
    @Singleton
    ListMapper<ApiPublicRepositories, PublicRepositories> providesApiPublicrepository(ApiPublicRepositoriesMapper apiPublicRepositories) {
        return new ListMapper<>(apiPublicRepositories);
    }
}
