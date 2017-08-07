package com.example.mypc.i_tour.Data;

/**
 * Created by MyPC on 02/08/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data_amthuc {

    @SerializedName("ID_amthuc")
    @Expose
    private String iDAmthuc;
    @SerializedName("Ten_amthuc")
    @Expose
    private String tenAmthuc;
    @SerializedName("ID_vung")
    @Expose
    private String iDVung;
    @SerializedName("MoTa")
    @Expose
    private String moTa;
    @SerializedName("HinhAnh")
    @Expose
    private String hinhAnh;

    public String getIDAmthuc() {
        return iDAmthuc;
    }

    public void setIDAmthuc(String iDAmthuc) {
        this.iDAmthuc = iDAmthuc;
    }

    public String getTenAmthuc() {
        return tenAmthuc;
    }

    public void setTenAmthuc(String tenAmthuc) {
        this.tenAmthuc = tenAmthuc;
    }

    public String getIDVung() {
        return iDVung;
    }

    public void setIDVung(String iDVung) {
        this.iDVung = iDVung;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

}

