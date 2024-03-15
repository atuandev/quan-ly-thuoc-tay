/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class Thuoc {

    private String id;
    private String ten;
    private byte[] hinhAnh;
    private String thanhPhan;
    private DonViTinh donViTinh;
    private DanhMuc danhMuc;
    private XuatXu xuatXu;
    private int soLuongTon;
    private double giaNhap;
    private double donGia;

    public Thuoc() {
    }

    public Thuoc(String id) {
        this.id = id;
    }

    public Thuoc(String id, String tenThuoc, byte[] hinhAnh, String thanhPhan, DonViTinh donViTinh, DanhMuc danhMuc, XuatXu xuatXu, int soLuong, double giaNhap, double donGia) {
        this.id = id;
        this.ten = tenThuoc;
        this.hinhAnh = hinhAnh;
        this.thanhPhan = thanhPhan;
        this.donViTinh = donViTinh;
        this.danhMuc = danhMuc;
        this.xuatXu = xuatXu;
        this.soLuongTon = soLuong;
        this.giaNhap = giaNhap;
        this.donGia = donGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenThuoc() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getThanhPhan() {
        return thanhPhan;
    }

    public void setThanhPhan(String thanhPhan) {
        this.thanhPhan = thanhPhan;
    }

    public DonViTinh getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(DonViTinh donViTinh) {
        this.donViTinh = donViTinh;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public XuatXu getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(XuatXu xuatXu) {
        this.xuatXu = xuatXu;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Thuoc other = (Thuoc) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return ten;
    }

}
