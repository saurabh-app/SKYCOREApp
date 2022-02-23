package com.example.skycoreapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MasterResponseModel implements Parcelable {

    @SerializedName("businesses")
    @Expose
    private List<Business> businesses = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("region")
    @Expose
    private Region region;

    protected MasterResponseModel(Parcel in) {
        if (in.readByte() == 0) {
            total = null;
        } else {
            total = in.readInt();
        }
    }

    public static final Creator<MasterResponseModel> CREATOR = new Creator<MasterResponseModel>() {
        @Override
        public MasterResponseModel createFromParcel(Parcel in) {
            return new MasterResponseModel(in);
        }

        @Override
        public MasterResponseModel[] newArray(int size) {
            return new MasterResponseModel[size];
        }
    };

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (total == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(total);
        }
    }

    @Override
    public String toString() {
        return "MasterResponseModel{" +
                "businesses=" + businesses +
                ", total=" + total +
                ", region=" + region +
                '}';
    }
}
