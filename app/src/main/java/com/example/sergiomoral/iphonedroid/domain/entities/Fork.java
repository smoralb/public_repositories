package com.example.sergiomoral.iphonedroid.domain.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Fork implements Serializable {

    private int id;
    private String name;

    private Fork(Builder builder) {
        setId(builder.id);
        setName(builder.name);
    }

    public Fork(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Fork() {
    }

    protected Fork(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static final class Builder {
        private int id;
        private String name;

        public Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Fork build() {
            return new Fork(this);
        }
    }
}
