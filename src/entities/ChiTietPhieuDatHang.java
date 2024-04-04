package entities;

import java.util.Objects;

/**
 *
 * @author HP
 */
public class ChiTietPhieuDatHang {

    private PhieuDatHang phieuDatHang;
    private Thuoc thuoc;
    private int soLuong;
    private double donGia;

    public ChiTietPhieuDatHang() {
    }

    public ChiTietPhieuDatHang(PhieuDatHang phieuDatHang, Thuoc thuoc, int soLuong, double donGia) {
        this.phieuDatHang = phieuDatHang;
        this.thuoc = thuoc;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public PhieuDatHang getPhieuDatHang() {
        return phieuDatHang;
    }

    public void setPhieuDatHang(PhieuDatHang phieuDatHang) {
        this.phieuDatHang = phieuDatHang;
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
        hash = 23 * hash + Objects.hashCode(this.phieuDatHang);
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
        final ChiTietPhieuDatHang other = (ChiTietPhieuDatHang) obj;
        return Objects.equals(this.phieuDatHang, other.phieuDatHang);
    }

    @Override
    public String toString() {
        return "ChiTietPhieuDatHang{" + "phieuDatHang=" + phieuDatHang + ", thuoc=" + thuoc + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

    public double getThanhTien() {
        return this.getSoLuong() * this.getDonGia();
    }
}
