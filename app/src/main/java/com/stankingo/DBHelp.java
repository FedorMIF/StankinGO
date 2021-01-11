package com.stankingo;

import android.os.Parcel;
import android.os.Parcelable;


public class DBHelp implements Parcelable {

    public String day = ""; // день
    public String classes = ""; // название пары
    public String data_start = ""; //дата начала
    public String data_end = ""; // дата конца
    public String period = ""; // чн или кн
    public String num = ""; // номер пары посчету
    public String aud = ""; // номер аудитории

    public String toOneStr(){
        String str = day + ',' + classes + ',' + data_start + ',' + data_end + ',' + period + ',' + num + ',' + aud + '\n';
        return str;
    }

    protected DBHelp(Parcel in) {
        day = in.readString();
        classes = in.readString();
        data_start = in.readString();
        data_end = in.readString();
        period = in.readString();
        num = in.readString();
        aud = in.readString();
    }

    public DBHelp (String d, String cl, String ds, String de, String p, String n, String a){
        day = d;
        classes = cl;
        data_start = ds;
        data_end = de;
        period = p;
        num = n;
        aud = a;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(day);
        dest.writeString(classes);
        dest.writeString(data_start);
        dest.writeString(data_end);
        dest.writeString(period);
        dest.writeString(num);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DBHelp> CREATOR = new Parcelable.Creator<DBHelp>() {
        @Override
        public DBHelp createFromParcel(Parcel in) {
            return new DBHelp(in);
        }

        @Override
        public DBHelp[] newArray(int size) {
            return new DBHelp[size];
        }
    };
}
