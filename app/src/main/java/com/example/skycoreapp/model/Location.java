package com.example.skycoreapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Location  implements Parcelable {

    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("address3")
    @Expose
    private String address3;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("display_address")
    @Expose
    private List<String> displayAddress = null;

    protected Location(Parcel in) {
        address1 = in.readString();
        address2 = in.readString();
        address3 = in.readString();
        city = in.readString();
        zipCode = in.readString();
        country = in.readString();
        state = in.readString();
        displayAddress = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address1);
        dest.writeString(address2);
        dest.writeString(address3);
        dest.writeString(city);
        dest.writeString(zipCode);
        dest.writeString(country);
        dest.writeString(state);
        dest.writeStringList(displayAddress);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getDisplayAddress() {
        return displayAddress;
    }

    public void setDisplayAddress(List<String> displayAddress) {
        this.displayAddress = displayAddress;
    }

    @Override
    public String toString() {
        return "Location{" +
                "address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", displayAddress=" + displayAddress +
                '}';
    }
}
