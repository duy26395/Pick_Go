package com.example.mypc.i_tour.Data;

/**
 * Created by MyPC on 03/08/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data_nhahang {

    @SerializedName("ID_nh")
    @Expose
    private String iDNh;
    @SerializedName("TenNH")
    @Expose
    private String tenNH;
    @SerializedName("DiaChi")
    @Expose
    private String diaChi;
    @SerializedName("SDT")
    @Expose
    private String sDT;
    @SerializedName("ID_vung")
    @Expose
    private String iDVung;

    public String getIDNh() {
        return iDNh;
    }

    public void setIDNh(String iDNh) {
        this.iDNh = iDNh;
    }

    public String getTenNH() {
        return tenNH;
    }

    public void setTenNH(String tenNH) {
        this.tenNH = tenNH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return sDT;
    }

    public void setSDT(String sDT) {
        this.sDT = sDT;
    }

    public String getIDVung() {
        return iDVung;
    }

    public void setIDVung(String iDVung) {
        this.iDVung = iDVung;
    }

}
