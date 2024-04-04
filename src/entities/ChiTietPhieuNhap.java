package entities;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class ChiTietPhieuNhap {

    private PhieuNhap phieuNhap;
    private Thuoc thuoc;
    private int soLuong;
    private double donGia;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(PhieuNhap phieuNhap, Thuoc thuoc, int soLuong, double donGia) {
        this.phieuNhap = phieuNhap;
        this.thuoc = thuoc;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public PhieuNhap getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhap phieuNhap) {
        this.phieuNhap = phieuNhap;
    }

    public Thuoc getThuoc() {
        return thuoc;
    }

    public void setThuoc(Thuoc thuoc) {
        this.thuoc = thuoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.phieuNhap);
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
        final ChiTietPhieuNhap other = (ChiTietPhieuNhap) obj;
        return true;
    }

    @Override
    public String toString() {
        return "ChiTietPhieuNhap{" + "phieuNhap=" + phieuNhap + ", thuoc=" + thuoc + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

    public double getThanhTien() {
        return this.getSoLuong() * this.getDonGia();
    }

}
