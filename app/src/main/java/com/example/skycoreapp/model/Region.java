package com.example.skycoreapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Region implements Parcelable {

    @SerializedName("center")
    @Expose
    private Center center;

    protected Region(Parcel in) {
        center = in.readParcelable(Center.class.getClassLoader());
    }

    public static final Creator<Region> CREATOR = new Creator<Region>() {
        @Override
        public Region createFromParcel(Parcel in) {
            return new Region(in);
        }

        @Override
        public Region[] newArray(int size) {
            return new Region[size];
        }
    };

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(center, i);
    }

    @Override
    public String toString() {
        return "Region{" +
                "center=" + center +
                '}';
    }
}
