package com.example.sergiomoral.iphonedroid.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;



public class PublicRepositories implements Parcelable {

    private int id;
    private String projectName;
    private String path;
    private Owner owner;
    private String isPrivate;
    private String projectUrl;
    private String description;
    private String forks;
    private String branches;
    private String contributors;
    private String issues;

    private PublicRepositories(Builder builder) {
        setId(builder.id);
        setProjectName(builder.projectName);
        setPath(builder.path);
        setOwner(builder.owner);
        setIsPrivate(builder.isPrivate);
        setProjectUrl(builder.projectUrl);
        setDescription(builder.description);
        setForks(builder.forks);
        setBranches(builder.branches);
        setContributors(builder.contributors);
        setIssues(builder.issues);
    }

    public PublicRepositories() {
    }

    public PublicRepositories(int id, String projectName, String path, Owner owner, String isPrivate, String projectUrl, String description, String forks, String branches, String contributors, String issues) {
        this.id = id;
        this.projectName = projectName;
        this.path = path;
        this.owner = owner;
        this.isPrivate = isPrivate;
        this.projectUrl = projectUrl;
        this.description = description;
        this.forks = forks;
        this.branches = branches;
        this.contributors = contributors;
        this.issues = issues;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getForks() {
        return forks;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }

    public String getContributors() {
        return contributors;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }


    public static final class Builder {
        private int id;
        private String projectName;
        private String path;
        private Owner owner;
        private String isPrivate;
        private String projectUrl;
        private String description;
        private String forks;
        private String branches;
        private String contributors;
        private String issues;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
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

        public Builder owner(Owner val) {
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

        public PublicRepositories build() {
            return new PublicRepositories(this);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.projectName);
        dest.writeString(this.path);
        dest.writeSerializable(this.owner);
        dest.writeString(this.isPrivate);
        dest.writeString(this.projectUrl);
        dest.writeString(this.description);
        dest.writeString(this.forks);
        dest.writeString(this.branches);
        dest.writeString(this.contributors);
        dest.writeString(this.issues);
    }

    protected PublicRepositories(Parcel in) {
        this.id = (int) in.readValue(Integer.class.getClassLoader());
        this.projectName = in.readString();
        this.path = in.readString();
        this.owner = (Owner) in.readSerializable();
        this.isPrivate = in.readString();
        this.projectUrl = in.readString();
        this.description = in.readString();
        this.forks = in.readString();
        this.branches = in.readString();
        this.contributors = in.readString();
        this.issues = in.readString();
    }

    public static final Creator<PublicRepositories> CREATOR = new Creator<PublicRepositories>() {
        @Override
        public PublicRepositories createFromParcel(Parcel source) {
            return new PublicRepositories(source);
        }

        @Override
        public PublicRepositories[] newArray(int size) {
            return new PublicRepositories[size];
        }
    };
}
