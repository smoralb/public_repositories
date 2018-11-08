package com.example.sergiomoral.iphonedroid.data.network.mapper;

import com.example.sergiomoral.iphonedroid.data.network.models.ApiPublicRepositories;
import com.example.sergiomoral.iphonedroid.domain.entities.PublicRepositories;
import com.example.sergiomoral.iphonedroid.domain.mappers.Mapper;

import javax.inject.Inject;

public class ApiPublicRepositoriesMapper implements Mapper<ApiPublicRepositories, PublicRepositories> {

    private ApiOwnerMapper mApiOwnerMapper;

    @Inject
    public ApiPublicRepositoriesMapper(ApiOwnerMapper mApiOwnerMapper) {
        this.mApiOwnerMapper = mApiOwnerMapper;
    }

    @Override
    public PublicRepositories map(ApiPublicRepositories model) {
        if (model == null) {
            return null;
        }

        return new PublicRepositories.Builder()
                .branches(model.getBranches())
                .contributors(model.getContributors())
                .description(model.getDescription())
                .forks(model.getForks())
                .id(model.getIdRepository())
                .isPrivate(model.getIsPrivate())
                .issues(model.getIssues())
                .owner(mApiOwnerMapper.map(model.getOwner()))
                .path(model.getPath())
                .projectName(model.getProjectName())
                .projectUrl(model.getProjectUrl())
                .build();
    }

    @Override
    public ApiPublicRepositories inverseMap(PublicRepositories model) {
        if (model == null) {
            return null;
        }

        return new ApiPublicRepositories.Builder()
                .branches(model.getBranches())
                .contributors(model.getContributors())
                .description(model.getDescription())
                .forks(model.getForks())
                .idRepository(model.getId())
                .isPrivate(model.getIsPrivate())
                .issues(model.getIssues())
                .owner(mApiOwnerMapper.inverseMap(model.getOwner()))
                .path(model.getPath())
                .projectName(model.getProjectName())
                .projectUrl(model.getProjectUrl())
                .build();
    }
}
