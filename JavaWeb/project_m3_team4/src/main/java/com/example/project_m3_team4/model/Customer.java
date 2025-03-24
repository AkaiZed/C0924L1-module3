package com.example.project_m3_team4.model;

import java.util.Date;

public class Customer {
    private String taiKhoan;
    private String matKhau;
    private String email;
    private String soDt;
    private Date dob;
    private String diaChi;

    public Customer() {
    }

    public Customer(String taiKhoan, String matKhau, String email, String soDt, Date dob, String diaChi) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.email = email;
        this.soDt = soDt;
        this.dob = dob;
        this.diaChi = diaChi;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDt() {
        return soDt;
    }

    public void setSoDt(String soDt) {
        this.soDt = soDt;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}