package com.example.sergiomoral.iphonedroid.domain.entities;

import java.io.Serializable;

public class Owner implements Serializable {

    private Integer id;
    private String userName;
    private String profilePicture;
    private String userUrl;
    private String followers;
    private String repositories;

    private Owner(Builder builder) {
        setId(builder.id);
        setUserName(builder.userName);
        setProfilePicture(builder.profilePicture);
        setUserUrl(builder.userUrl);
        setFollowers(builder.followers);
        setRepositories(builder.repositories);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getRepositories() {
        return repositories;
    }

    public void setRepositories(String repositories) {
        this.repositories = repositories;
    }

    public static final class Builder {
        private Integer id;
        private String userName;
        private String profilePicture;
        private String userUrl;
        private String followers;
        private String repositories;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
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

        public Builder repositories(String val) {
            repositories = val;
            return this;
        }

        public Owner build() {
            return new Owner(this);
        }
    }
}
