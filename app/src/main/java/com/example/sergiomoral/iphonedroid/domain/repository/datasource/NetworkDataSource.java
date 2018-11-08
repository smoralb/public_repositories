package com.example.sergiomoral.iphonedroid.domain.repository.datasource;

import com.example.sergiomoral.iphonedroid.domain.entities.Contributor;
import com.example.sergiomoral.iphonedroid.domain.entities.Fork;
import com.example.sergiomoral.iphonedroid.domain.entities.Issue;
import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;

import java.util.List;

public interface NetworkDataSource {

    List<PublicRepositories> getPublicRepositories(int lastID);

    List<Contributor> getContributors(String userName, String projectName);

    List<Fork> getForks(String userName, String projectName);

    Issue getIssues(String userName, String projectName);
}
