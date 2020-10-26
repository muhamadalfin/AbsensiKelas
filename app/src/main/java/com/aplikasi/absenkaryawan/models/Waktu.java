package com.aplikasi.absenkaryawan.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Waktu implements Parcelable {

    private String name;
    private String hari;
    private Date tgl;

    public Waktu() {
    }

    public Waktu(String name, String hari, Date tgl) {
        this.name = name;
        this.hari = hari;
        this.tgl = tgl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.hari);
        dest.writeLong(this.tgl != null ? this.tgl.getTime() : -1);
    }

    protected Waktu(Parcel in) {
        this.name = in.readString();
        this.hari = in.readString();
        long tmpTgl = in.readLong();
        this.tgl = tmpTgl == -1 ? null : new Date(tmpTgl);
    }

    public static final Creator<Waktu> CREATOR = new Creator<Waktu>() {
        @Override
        public Waktu createFromParcel(Parcel source) {
            return new Waktu(source);
        }

        @Override
        public Waktu[] newArray(int size) {
            return new Waktu[size];
        }
    };
}
