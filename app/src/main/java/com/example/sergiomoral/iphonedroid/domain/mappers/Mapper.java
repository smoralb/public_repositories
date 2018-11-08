package com.example.sergiomoral.iphonedroid.domain.mappers;

public interface Mapper<M, P> {

    P map(M model);

    M inverseMap(P model);
}
