package com.example.sergiomoral.iphonedroid.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiPublicRepositories {

    @SerializedName("id")
    @Expose
    private Integer idRepository;

    @SerializedName("name")
    @Expose
    private String projectName;

    @SerializedName("full_name")
    @Expose
    private String path;

    @SerializedName("owner")
    @Expose
    private ApiOwner owner;

    @SerializedName("private")
    @Expose
    private String isPrivate;

    @SerializedName("html_url")
    @Expose
    private String projectUrl;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("forks_url")
    @Expose
    private String forks;

    @SerializedName("branches_url")
    @Expose
    private String branches;

    @SerializedName("contributors_url")
    @Expose
    private String contributors;

    @SerializedName("issues_url")
    @Expose
    private String issues;

    public ApiPublicRepositories() {
    }

    private ApiPublicRepositories(Builder builder) {
        idRepository = builder.idRepository;
        projectName = builder.projectName;
        path = builder.path;
        owner = builder.owner;
        isPrivate = builder.isPrivate;
        projectUrl = builder.projectUrl;
        description = builder.description;
        forks = builder.forks;
        branches = builder.branches;
        contributors = builder.contributors;
        issues = builder.issues;
    }

    public Integer getIdRepository() {
        return idRepository;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getPath() {
        return path;
    }

    public ApiOwner getOwner() {
        return owner;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getForks() {
        return forks;
    }

    public String getBranches() {
        return branches;
    }

    public String getContributors() {
        return contributors;
    }

    public String getIssues() {
        return issues;
    }

    public static final class Builder {
        private Integer idRepository;
        private String projectName;
        private String path;
        private ApiOwner owner;
        private String isPrivate;
        private String projectUrl;
        private String description;
        private String forks;
        private String branches;
        private String contributors;
        private String issues;

        public Builder() {
        }

        public Builder idRepository(Integer val) {
            idRepository = val;
            return this;
        }

        public Builder projectName(String val) {
            projectName = val;
            return this;
        }

        public Builder path(String val) {
            path = val;
            return this;
        }

        public Builder owner(ApiOwner val) {
            owner = val;
            return this;
        }

        public Builder isPrivate(String val) {
            isPrivate = val;
            return this;
        }

        public Builder projectUrl(String val) {
            projectUrl = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder forks(String val) {
            forks = val;
            return this;
        }

        public Builder branches(String val) {
            branches = val;
            return this;
        }

        public Builder contributors(String val) {
            contributors = val;
            return this;
        }

        public Builder issues(String val) {
            issues = val;
            return this;
        }

        public ApiPublicRepositories build() {
            return new ApiPublicRepositories(this);
        }
    }
}
