package com.example.skycoreapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Business implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("is_closed")
    @Expose
    private Boolean isClosed;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("review_count")
    @Expose
    private Integer reviewCount;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("coordinates")
    @Expose
    private Coordinates coordinates;
    @SerializedName("transactions")
    @Expose
    private List<String> transactions = null;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("display_phone")
    @Expose
    private String displayPhone;
    @SerializedName("distance")
    @Expose
    private Double distance;

    protected Business(Parcel in) {
        id = in.readString();
        alias = in.readString();
        name = in.readString();
        imageUrl = in.readString();
        byte tmpIsClosed = in.readByte();
        isClosed = tmpIsClosed == 0 ? null : tmpIsClosed == 1;
        url = in.readString();
        if (in.readByte() == 0) {
            reviewCount = null;
        } else {
            reviewCount = in.readInt();
        }
        categories = in.createTypedArrayList(Category.CREATOR);
        if (in.readByte() == 0) {
            rating = null;
        } else {
            rating = in.readDouble();
        }
        coordinates = in.readParcelable(Coordinates.class.getClassLoader());
        transactions = in.createStringArrayList();
        price = in.readString();
        location = in.readParcelable(Location.class.getClassLoader());
        phone = in.readString();
        displayPhone = in.readString();
        if (in.readByte() == 0) {
            distance = null;
        } else {
            distance = in.readDouble();
        }
    }

    public static final Creator<Business> CREATOR = new Creator<Business>() {
        @Override
        public Business createFromParcel(Parcel in) {
            return new Business(in);
        }

        @Override
        public Business[] newArray(int size) {
            return new Business[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDisplayPhone() {
        return displayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        this.displayPhone = displayPhone;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(alias);
        parcel.writeString(name);
        parcel.writeString(imageUrl);
        parcel.writeByte((byte) (isClosed == null ? 0 : isClosed ? 1 : 2));
        parcel.writeString(url);
        if (reviewCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(reviewCount);
        }
        parcel.writeTypedList(categories);
        if (rating == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(rating);
        }
        parcel.writeParcelable(coordinates, i);
        parcel.writeStringList(transactions);
        parcel.writeString(price);
        parcel.writeParcelable(location, i);
        parcel.writeString(phone);
        parcel.writeString(displayPhone);
        if (distance == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(distance);
        }
    }

    @Override
    public String toString() {
        return "Business{" +
                "id='" + id + '\'' +
                ", alias='" + alias + '\'' +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", isClosed=" + isClosed +
                ", url='" + url + '\'' +
                ", reviewCount=" + reviewCount +
                ", categories=" + categories +
                ", rating=" + rating +
                ", coordinates=" + coordinates +
                ", transactions=" + transactions +
                ", price='" + price + '\'' +
                ", location=" + location +
                ", phone='" + phone + '\'' +
                ", displayPhone='" + displayPhone + '\'' +
                ", distance=" + distance +
                '}';
    }
}
