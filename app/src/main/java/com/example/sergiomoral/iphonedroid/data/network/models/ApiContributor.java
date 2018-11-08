package com.example.sergiomoral.iphonedroid.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiContributor {

    @SerializedName("login")
    @Expose
    private String userName;

    @SerializedName("avatar_url")
    @Expose
    private String profilePicture;

    @SerializedName("contributions")
    @Expose
    private int contributions;

    private ApiContributor(Builder builder) {
        userName = builder.userName;
        profilePicture = builder.profilePicture;
        contributions = builder.contributions;
    }

    public String getUserName() {
        return userName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public int getContributions() {
        return contributions;
    }


    public static final class Builder {
        private String userName;
        private String profilePicture;
        private int contributions;

        public Builder() {
        }

        public Builder userName(String val) {
            userName = val;
            return this;
        }

        public Builder profilePicture(String val) {
            profilePicture = val;
            return this;
        }

        public Builder contributions(int val) {
            contributions = val;
            return this;
        }

        public ApiContributor build() {
            return new ApiContributor(this);
        }
    }
}
