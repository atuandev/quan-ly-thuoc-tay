/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author HP
 */
public class ChiTietPhieuThu {

    private PhieuThu idPhieuThu;
    private Thuoc idThuoc;
    private Date thoiGian;
    private int soLuong;
    private double thanhTien;

    public ChiTietPhieuThu() {
    }

    public ChiTietPhieuThu(PhieuThu idPhieuThu) {
        this.idPhieuThu = idPhieuThu;
    }

    public ChiTietPhieuThu(PhieuThu idPhieuThu, Thuoc idThuoc, Date thoiGian, int soLuong, double thanhTien) {
        this.idPhieuThu = idPhieuThu;
        this.idThuoc = idThuoc;
        this.thoiGian = thoiGian;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public PhieuThu getIdPhieuThu() {
        return idPhieuThu;
    }

    public void setIdPhieuThu(PhieuThu idPhieuThu) {
        this.idPhieuThu = idPhieuThu;
    }

    public Thuoc getIdThuoc() {
        return idThuoc;
    }

    public void setIdThuoc(Thuoc idThuoc) {
        this.idThuoc = idThuoc;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuThu{" + "idPhieuThu=" + idPhieuThu + ", idThuoc=" + idThuoc + ", thoiGian=" + thoiGian + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + '}';
    }

}
