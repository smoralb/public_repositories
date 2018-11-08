package com.example.sergiomoral.iphonedroid.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Contributor implements Serializable {

    private String userName;
    private String profilePicture;
    private int contributions;

    private Contributor(Builder builder) {
        setUserName(builder.userName);
        setProfilePicture(builder.profilePicture);
        setContributions(builder.contributions);
    }

    public Contributor(String userName, String profilePicture, int contributions) {
        this.userName = userName;
        this.profilePicture = profilePicture;
        this.contributions = contributions;
    }

    public Contributor() {
    }

    protected Contributor(Parcel in) {
        this.userName = in.readString();
        this.profilePicture = in.readString();
        this.contributions = in.readInt();
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

    public Integer getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
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

        public Contributor build() {
            return new Contributor(this);
        }
    }
}
