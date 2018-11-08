package com.example.sergiomoral.iphonedroid.data.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiIssue {

    @SerializedName("number")
    @Expose
    private int issueNumber;

    private ApiIssue(Builder builder) {
        issueNumber = builder.issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }


    public static final class Builder {
        private int issueNumber;

        public Builder() {
        }

        public Builder issueNumber(int val) {
            issueNumber = val;
            return this;
        }

        public ApiIssue build() {
            return new ApiIssue(this);
        }
    }
}
