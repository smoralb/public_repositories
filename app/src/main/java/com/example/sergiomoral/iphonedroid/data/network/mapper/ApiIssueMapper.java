package com.example.sergiomoral.iphonedroid.data.network.mapper;

import com.example.sergiomoral.iphonedroid.data.network.models.ApiIssue;
import com.example.sergiomoral.iphonedroid.domain.entities.Issue;
import com.example.sergiomoral.iphonedroid.domain.mappers.Mapper;

import javax.inject.Inject;

public class ApiIssueMapper implements Mapper<ApiIssue, Issue> {

    @Inject
    public ApiIssueMapper() {
    }

    @Override
    public Issue map(ApiIssue model) {
        if (model == null) {
            return null;
        }

        return new Issue.Builder()
                .number(model.getIssueNumber())
                .build();
    }

    @Override
    public ApiIssue inverseMap(Issue model) {
        if (model == null) {
            return null;
        }

        return new ApiIssue.Builder()
                .issueNumber(model.getNumber())
                .build();
    }
}
