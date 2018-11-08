package com.example.sergiomoral.iphonedroid.data.network.mapper;

import com.example.sergiomoral.iphonedroid.data.network.models.ApiFork;
import com.example.sergiomoral.iphonedroid.domain.entities.Fork;
import com.example.sergiomoral.iphonedroid.domain.mappers.Mapper;
import javax.inject.Inject;

public class ApiForkMapper implements Mapper<ApiFork, Fork> {


    @Inject
    public ApiForkMapper() {
    }

    @Override
    public Fork map(ApiFork model) {
        if (model == null) {
            return null;
        }

        return new Fork.Builder()
                .id(model.getIdFork())
                .name(model.getForkName())
                .build();
    }

    @Override
    public ApiFork inverseMap(Fork model) {
        if (model == null) {
            return null;
        }
        return new ApiFork.Builder()
                .forkName(model.getName())
                .idFork(model.getId())
                .build();
    }
}
