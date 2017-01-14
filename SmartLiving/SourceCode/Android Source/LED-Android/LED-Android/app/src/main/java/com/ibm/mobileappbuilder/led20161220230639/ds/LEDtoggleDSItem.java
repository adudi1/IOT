
package com.ibm.mobileappbuilder.led20161220230639.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class LEDtoggleDSItem implements Parcelable, IdentifiableBean {

    @SerializedName("togglevalue") public Boolean togglevalue;
    @SerializedName("id") public String id;

    @Override
    public String getIdentifiableId() {
      return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(togglevalue);
        dest.writeString(id);
    }

    public static final Creator<LEDtoggleDSItem> CREATOR = new Creator<LEDtoggleDSItem>() {
        @Override
        public LEDtoggleDSItem createFromParcel(Parcel in) {
            LEDtoggleDSItem item = new LEDtoggleDSItem();

            item.togglevalue = (Boolean) in.readValue(null);
            item.id = in.readString();
            return item;
        }

        @Override
        public LEDtoggleDSItem[] newArray(int size) {
            return new LEDtoggleDSItem[size];
        }
    };

}

