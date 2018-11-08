package com.example.sergiomoral.iphonedroid.domain.repository;

import android.util.Log;

import com.example.sergiomoral.iphonedroid.domain.entities.Contributor;
import com.example.sergiomoral.iphonedroid.domain.entities.Fork;
import com.example.sergiomoral.iphonedroid.domain.entities.Issue;
import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;
import com.example.sergiomoral.iphonedroid.domain.repository.datasource.NetworkDataSource;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class Repository {

    private static final String TAG = "Repository";

    private NetworkDataSource mNetworkDataSource;
    private Gson mGson;

    @Inject
    public Repository(NetworkDataSource mNetworkDataSource, Gson mGson) {
        this.mNetworkDataSource = mNetworkDataSource;
        this.mGson = mGson;
    }


    public List<PublicRepositories> getPublicrepositories(int lastID) {
        List<PublicRepositories> publicRepositories;
        try {
            publicRepositories = mNetworkDataSource.getPublicRepositories(lastID);
        } catch (Exception exception) {
            Log.d(TAG, "getPublicrepositories: Error al devolver repositorios publicos");
            throw exception;
        }
        return publicRepositories;
    }

    public List<Contributor> getContributors(String userName, String projectName) {
        List<Contributor> contributors;
        try {
            contributors = mNetworkDataSource.getContributors(userName, projectName);
        } catch (Exception exception){
            Log.d(TAG, "getContributors: Error al devolver colaboradores");
            throw exception;
        }
        return contributors;
    }

    public List<Fork> getForks(String userName, String projectName) {
        List<Fork> forks;
        try {
            forks = mNetworkDataSource.getForks(userName, projectName);
        } catch (Exception exception){
            Log.d(TAG, "getContributors: Error al devolver colaboradores");
            throw exception;
        }
        return forks;
    }

    public Issue getIssues(String userName, String projectName) {
        Issue issues;
        try {
            issues = mNetworkDataSource.getIssues(userName, projectName);
        } catch (Exception exception){
            Log.d(TAG, "getContributors: Error al devolver colaboradores");
            throw exception;
        }
        return issues;
    }
}
