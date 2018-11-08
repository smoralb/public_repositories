package com.example.sergiomoral.iphonedroid.data.network.mapper;

import com.example.sergiomoral.iphonedroid.data.network.models.ApiContributor;
import com.example.sergiomoral.iphonedroid.domain.entities.Contributor;
import com.example.sergiomoral.iphonedroid.domain.mappers.Mapper;

import javax.inject.Inject;

public class ApiContributorMapper implements Mapper<ApiContributor, Contributor> {


    @Inject
    public ApiContributorMapper() {
    }

    @Override
    public Contributor map(ApiContributor model) {
        if (model == null) {
            return null;
        }

        return new Contributor.Builder()
                .contributions(model.getContributions())
                .profilePicture(model.getProfilePicture())
                .userName(model.getUserName())
                .build();
    }

    @Override
    public ApiContributor inverseMap(Contributor model) {
        if (model == null) {
            return null;
        }

        return new ApiContributor.Builder()
                .contributions(model.getContributions())
                .profilePicture(model.getProfilePicture())
                .userName(model.getUserName())
                .build();
    }
}
