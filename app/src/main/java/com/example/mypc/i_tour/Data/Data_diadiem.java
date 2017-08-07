package com.example.mypc.i_tour.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 02/08/2017.
 */

public class Data_diadiem {
    @SerializedName("ID_dd")
    @Expose
    private String iDDd;
    @SerializedName("Tendd")
    @Expose
    private String tendd;
    @SerializedName("Mota")
    @Expose
    private String mota;
    @SerializedName("HinhAnh")
    @Expose
    private String hinhAnh;
    @SerializedName("ID_vung")
    @Expose
    private String iDVung;

    public String getIDDd() {
        return iDDd;
    }

    public void setIDDd(String iDDd) {
        this.iDDd = iDDd;
    }

    public String getTendd() {
        return tendd;
    }

    public void setTendd(String tendd) {
        this.tendd = tendd;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getIDVung() {
        return iDVung;
    }

    public void setIDVung(String iDVung) {
        this.iDVung = iDVung;
    }

}
