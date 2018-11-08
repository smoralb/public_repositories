package com.example.sergiomoral.iphonedroid.data.network.mapper;

import com.example.sergiomoral.iphonedroid.data.network.models.ApiOwner;
import com.example.sergiomoral.iphonedroid.domain.entities.Owner;
import com.example.sergiomoral.iphonedroid.domain.mappers.Mapper;
import javax.inject.Inject;

public class ApiOwnerMapper implements Mapper<ApiOwner, Owner> {


    @Inject
    public ApiOwnerMapper() {
    }

    @Override
    public Owner map(ApiOwner model) {
        if (model == null) {
            return null;
        }

        return new Owner.Builder()
                .followers(model.getFollowers())
                .id(model.getIdOwner())
                .profilePicture(model.getProfilePicture())
                .repositories(model.getRespositories())
                .userName(model.getUserName())
                .userUrl(model.getUserUrl())
                .build();
    }

    @Override
    public ApiOwner inverseMap(Owner model) {
        if (model == null) {
            return null;
        }

        return new ApiOwner.Builder()
                .followers(model.getFollowers())
                .idOwner(model.getId())
                .respositories(model.getRepositories())
                .profilePicture(model.getProfilePicture())
                .userName(model.getUserName())
                .userUrl(model.getUserUrl())
                .build();
    }
}
