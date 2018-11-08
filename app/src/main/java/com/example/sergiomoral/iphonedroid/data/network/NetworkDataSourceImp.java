package com.example.sergiomoral.iphonedroid.data.network;

import android.app.Application;
import android.util.Log;

import com.example.sergiomoral.iphonedroid.data.network.models.ApiContributor;
import com.example.sergiomoral.iphonedroid.data.network.models.ApiFork;
import com.example.sergiomoral.iphonedroid.data.network.models.ApiIssue;
import com.example.sergiomoral.iphonedroid.data.network.models.ApiOwner;
import com.example.sergiomoral.iphonedroid.data.network.models.ApiPublicRepositories;
import com.example.sergiomoral.iphonedroid.domain.entities.Contributor;
import com.example.sergiomoral.iphonedroid.domain.entities.Fork;
import com.example.sergiomoral.iphonedroid.domain.entities.Issue;
import com.example.sergiomoral.iphonedroid.domain.entities.Owner;
import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;
import com.example.sergiomoral.iphonedroid.domain.mappers.ListMapper;
import com.example.sergiomoral.iphonedroid.domain.repository.datasource.NetworkDataSource;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

public class NetworkDataSourceImp implements NetworkDataSource {

    private static final String TAG = "NetworkDataSourceImp";

    private Application mContext;
    private ApiService mApiService;
    private Gson gson;

    private ListMapper<ApiPublicRepositories, PublicRepositories> mPublicrepositoriesMapper;
    private ListMapper<ApiContributor, Contributor> mContributorMapper;
    private ListMapper<ApiFork, Fork> mForkMapper;
    private ListMapper<ApiIssue, Issue> mIssueMapper;
    private ListMapper<ApiOwner, Owner> mOwnerMapper;

    @Inject
    public NetworkDataSourceImp(Application mContext, ApiService mApiService, ListMapper<ApiPublicRepositories, PublicRepositories> mPublicrepositoriesMapper,
                                ListMapper<ApiContributor, Contributor> mContributorMapper, ListMapper<ApiFork, Fork> mForkMapper,
                                ListMapper<ApiIssue, Issue> mIssueMapper, ListMapper<ApiOwner, Owner> mOwnerMapper) {
        this.mContext = mContext;
        this.mApiService = mApiService;
        this.gson = new Gson();
        this.mPublicrepositoriesMapper = mPublicrepositoriesMapper;
        this.mContributorMapper = mContributorMapper;
        this.mForkMapper = mForkMapper;
        this.mIssueMapper = mIssueMapper;
        this.mOwnerMapper = mOwnerMapper;
    }

    @Override
    public List<PublicRepositories> getPublicRepositories(int lastId) {
        try {
            List<ApiPublicRepositories> apiPublicRepositories = mApiService.getPublicRepositories(lastId).execute().body();
                return mPublicrepositoriesMapper.map(apiPublicRepositories);
        } catch (Exception exception) {
            Log.d(TAG, "getPublicRepositories: Lllamada de respositorios públicos");
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    @Override
    public List<Contributor> getContributors(String userName, String projectName) {
        try {
            List<ApiContributor> apiContributors = mApiService.getContributors(userName, projectName).execute().body();
            return mContributorMapper.map(apiContributors);
        } catch (Exception exception) {
            Log.d(TAG, "getContributors: Llamada de colaboradores");
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    @Override
    public List<Fork> getForks(String userName, String projectName) {
        try {
            List<ApiFork> apiForkMapper = mApiService.getForks(userName, projectName).execute().body();
            return mForkMapper.map(apiForkMapper);
        } catch (Exception exception) {
            Log.d(TAG, "getContributors: Llamada de colaboradores");
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    @Override
    public Issue getIssues(String userName, String projectName) {
        try {
            List<ApiIssue> apiIssues = mApiService.getIssues(userName, projectName).execute().body();
            return mIssueMapper.map(apiIssues).get(0);
        } catch (Exception exception) {
            Log.d(TAG, "getContributors: Llamada de colaboradores");
            throw new IllegalArgumentException(exception.getMessage());
        }
    }
}
