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
public class ChiTietHoaDon {

    private HoaDon idHoadon;
    private Thuoc idThuoc;
    private Date thoiGian;
    private int soLuong;
    private double thanhTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(HoaDon idHoadon) {
        this.idHoadon = idHoadon;
    }

    public ChiTietHoaDon(HoaDon idHoadon, Thuoc idThuoc, Date thoiGian, int soLuong, double thanhTien) {
        this.idHoadon = idHoadon;
        this.idThuoc = idThuoc;
        this.thoiGian = thoiGian;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public HoaDon getIdHoadon() {
        return idHoadon;
    }

    public void setIdHoadon(HoaDon idHoadon) {
        this.idHoadon = idHoadon;
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
        return "ChiTietHoaDon{" + "idHoadon=" + idHoadon + ", idThuoc=" + idThuoc + ", thoiGian=" + thoiGian + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + '}';
    }

}
