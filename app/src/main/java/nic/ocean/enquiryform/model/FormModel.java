package nic.ocean.enquiryform.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FormModel implements Parcelable {

    private String fName;
    private String lName;
    private String conNum;
    private String email;
    private String gender;
    private String course;

    public FormModel(String fName, String lName, String conNum, String email, String gender, String course) {
        this.fName = fName;
        this.lName = lName;
        this.conNum = conNum;
        this.email = email;
        this.gender = gender;
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getConNum() {
        return conNum;
    }

    public void setConNum(String conNum) {
        this.conNum = conNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    protected FormModel(Parcel in) {
        fName = in.readString();
        lName = in.readString();
        conNum = in.readString();
        email = in.readString();
        gender = in.readString();
        course = in.readString();
    }

    public static final Creator<FormModel> CREATOR = new Creator<FormModel>() {
        @Override
        public FormModel createFromParcel(Parcel in) {
            return new FormModel(in);
        }

        @Override
        public FormModel[] newArray(int size) {
            return new FormModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(fName);
        parcel.writeString(lName);
        parcel.writeString(conNum);
        parcel.writeString(email);
        parcel.writeString(gender);
        parcel.writeString(course);
    }
}
