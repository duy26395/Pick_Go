package com.example.mypc.i_tour.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 03/08/2017.
 */

public class Data_khachsan {
    @SerializedName("ID_ks")
    @Expose
    private String iDKs;
    @SerializedName("TenKS")
    @Expose
    private String tenKS;
    @SerializedName("DiaChi")
    @Expose
    private String diaChi;
    @SerializedName("SDT")
    @Expose
    private String sDT;
    @SerializedName("ID_vung")
    @Expose
    private String iDVung;

    public String getIDKs() {
        return iDKs;
    }

    public void setIDKs(String iDKs) {
        this.iDKs = iDKs;
    }

    public String getTenKS() {
        return tenKS;
    }

    public void setTenKS(String tenKS) {
        this.tenKS = tenKS;
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
