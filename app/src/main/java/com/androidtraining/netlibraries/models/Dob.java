
package com.androidtraining.netlibraries.models;

import java.util.HashMap;
import java.util.Map;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Dob implements Parcelable
{

    private String date;
    private Integer age;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Parcelable.Creator<Dob> CREATOR = new Creator<Dob>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Dob createFromParcel(Parcel in) {
            return new Dob(in);
        }

        public Dob[] newArray(int size) {
            return (new Dob[size]);
        }

    }
    ;

    protected Dob(Parcel in) {
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.age = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public Dob() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(date);
        dest.writeValue(age);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public String toString() {
        return "Dob{" +
                "date='" + date + '\'' +
                ", age=" + age +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
