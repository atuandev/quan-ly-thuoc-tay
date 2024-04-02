package entities;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author atuandev
 */
public class HoaDon {

    private String id;
    private Timestamp thoiGian;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private double tongTien;

    public HoaDon() {
    }

    public HoaDon(String id) {
        this.id = id;
    }

    public HoaDon(String id, Timestamp thoiGian, NhanVien nhanVien, KhachHang khachHang, double tongTien) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.tongTien = tongTien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Timestamp thoiGian) {
        this.thoiGian = thoiGian;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final HoaDon other = (HoaDon) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", thoiGian=" + thoiGian + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + '}';
    }

}
