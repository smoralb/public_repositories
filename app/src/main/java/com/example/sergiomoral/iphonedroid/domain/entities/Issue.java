package com.example.sergiomoral.iphonedroid.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Issue implements Serializable {

    private Integer number;

    public Issue(Integer number) {
        this.number = number;
    }

    private Issue(Builder builder) {
        setNumber(builder.number);
    }

    protected Issue(Parcel in) {
        this.number = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    public static final class Builder {
        private Integer number;

        public Builder() {
        }

        public Builder number(Integer val) {
            number = val;
            return this;
        }

        public Issue build() {
            return new Issue(this);
        }
    }
}
