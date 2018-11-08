package com.example.sergiomoral.iphonedroid.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiOwner {

    @SerializedName("id")
    @Expose
    private Integer idOwner;

    @SerializedName("login")
    @Expose
    private String userName;

    @SerializedName("avatar_url")
    @Expose
    private String profilePicture;

    @SerializedName("html_url")
    @Expose
    private String userUrl;

    @SerializedName("followers_url")
    @Expose
    private String followers;

    @SerializedName("repos_url")
    @Expose
    private String respositories;

    public ApiOwner() {
    }

    public ApiOwner(Integer idOwner, String userName, String profilePicture, String userUrl, String followers, String respositories) {
        this.idOwner = idOwner;
        this.userName = userName;
        this.profilePicture = profilePicture;
        this.userUrl = userUrl;
        this.followers = followers;
        this.respositories = respositories;
    }

    private ApiOwner(Builder builder) {
        idOwner = builder.idOwner;
        userName = builder.userName;
        profilePicture = builder.profilePicture;
        userUrl = builder.userUrl;
        followers = builder.followers;
        respositories = builder.respositories;
    }

    public Integer getIdOwner() {
        return idOwner;
    }

    public String getUserName() {
        return userName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public String getFollowers() {
        return followers;
    }

    public String getRespositories() {
        return respositories;
    }


    public static final class Builder {
        private Integer idOwner;
        private String userName;
        private String profilePicture;
        private String userUrl;
        private String followers;
        private String respositories;

        public Builder() {
        }

        public Builder idOwner(Integer val) {
            idOwner = val;
            return this;
        }

        public Builder userName(String val) {
            userName = val;
            return this;
        }

        public Builder profilePicture(String val) {
            profilePicture = val;
            return this;
        }

        public Builder userUrl(String val) {
            userUrl = val;
            return this;
        }

        public Builder followers(String val) {
            followers = val;
            return this;
        }

        public Builder respositories(String val) {
            respositories = val;
            return this;
        }

        public ApiOwner build() {
            return new ApiOwner(this);
        }
    }
}
