package com.example.sergiomoral.iphonedroid.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiFork {

    @SerializedName("id")
    @Expose
    private int idFork;
    @SerializedName("name")
    @Expose
    private String forkName;

    private ApiFork(Builder builder) {
        idFork = builder.idFork;
        forkName = builder.forkName;
    }

    public int getIdFork() {
        return idFork;
    }

    public String getForkName() {
        return forkName;
    }


    public static final class Builder {
        private Integer idFork;
        private String forkName;

        public Builder() {
        }

        public Builder idFork(Integer val) {
            idFork = val;
            return this;
        }

        public Builder forkName(String val) {
            forkName = val;
            return this;
        }

        public ApiFork build() {
            return new ApiFork(this);
        }
    }
}
