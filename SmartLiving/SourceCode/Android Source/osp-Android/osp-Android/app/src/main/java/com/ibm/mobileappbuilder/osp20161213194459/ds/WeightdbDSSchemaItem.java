
package com.ibm.mobileappbuilder.osp20161213194459.ds;

import ibmmobileappbuilder.mvp.model.MutableIdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class WeightdbDSSchemaItem implements Parcelable, MutableIdentifiableBean {

    private transient String cloudantIdentifiableId;

    @SerializedName("Name") public String name;
    @SerializedName("weight") public Long weight;
    @SerializedName("date") public String date;

    @Override
    public void setIdentifiableId(String id) {
        this.cloudantIdentifiableId = id;
    }

    @Override
    public String getIdentifiableId() {
        return cloudantIdentifiableId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cloudantIdentifiableId);
        dest.writeString(name);
        dest.writeValue(weight);
        dest.writeString(date);
    }

    public static final Creator<WeightdbDSSchemaItem> CREATOR = new Creator<WeightdbDSSchemaItem>() {
        @Override
        public WeightdbDSSchemaItem createFromParcel(Parcel in) {
            WeightdbDSSchemaItem item = new WeightdbDSSchemaItem();
            item.cloudantIdentifiableId = in.readString();

            item.name = in.readString();
            item.weight = (Long) in.readValue(null);
            item.date = in.readString();
            return item;
        }

        @Override
        public WeightdbDSSchemaItem[] newArray(int size) {
            return new WeightdbDSSchemaItem[size];
        }
    };
}

