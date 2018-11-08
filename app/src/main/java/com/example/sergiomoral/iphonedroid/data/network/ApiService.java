package com.example.sergiomoral.iphonedroid.data.network;

import com.example.sergiomoral.iphonedroid.data.network.models.ApiContributor;
import com.example.sergiomoral.iphonedroid.data.network.models.ApiFork;
import com.example.sergiomoral.iphonedroid.data.network.models.ApiIssue;
import com.example.sergiomoral.iphonedroid.data.network.models.ApiPublicRepositories;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/repositories?")
    Call<List<ApiPublicRepositories>> getPublicRepositories(@Query("since") int lastId);

    @GET("/repos/{user}/{project}/contributors")
    Call<List<ApiContributor>> getContributors(@Path("user") String userName, @Path("project") String projectName);

    @GET("/repos/{user}/{project}/forks")
    Call<List<ApiFork>> getForks(@Path("user") String userName, @Path("project") String projectName);

    @GET("/repos/{user}/{project}/issues")
    Call<List<ApiIssue>> getIssues(@Path("user") String userName, @Path("project") String projectName);
}
