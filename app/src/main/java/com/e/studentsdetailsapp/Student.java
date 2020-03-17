package com.e.studentsdetailsapp;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class Student implements Parcelable {

    private String firstName;
    private String secondName;
    private String groupeNumber;
    private int avatar;
    private Boolean isChecked;

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Student createFromParcel(Parcel source) {
            String firstName = source.readString();
            String secondName = source.readString();
            String groupeNumber = source.readString();
            int ava = source.readInt();
            Student std = new Student();
            std.firstName = firstName; std.secondName = secondName;
            std.groupeNumber = groupeNumber; std.avatar = ava; std.isChecked = false;
            return std;
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    Student(String firstName, String secondName,
            String groupeNumber, Boolean isMale){
        this.firstName = firstName;
        this.secondName = secondName;
        this.groupeNumber = groupeNumber;
        if(isMale){
            this.avatar = R.drawable.male_profile;
        }else{
            this.avatar = R.drawable.female_profile;
        }
        this.isChecked = false;
    }
    Student(){}

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getGroupeNumber() {
        return this.groupeNumber;
    }
    public void setGroupeNumber(String groupeNumber) {
        this.groupeNumber = groupeNumber;
    }

    public int getAvatar() {
        return this.avatar;
    }
    public void setAvatar(Boolean isMale) {
        if(isMale){
            this.avatar = R.drawable.male_profile;
        }else{
            this.avatar = R.drawable.female_profile;
        }
    }

    public Boolean getIsChecked() {
        return this.isChecked;
    }
    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(firstName);
        parcel.writeString(secondName);
        parcel.writeString(groupeNumber);
        parcel.writeInt(avatar);
    }
}
