package entity;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author atuandev
 */
public class HoaDon {

    private String id;
    private LocalDateTime thoiGian;
    private NhanVien nhanVien;
    private KhachHang khachHang;

    public HoaDon() {
    }

    public HoaDon(String id) {
        this.id = id;
    }

    public HoaDon(String id, LocalDateTime thoiGian, NhanVien nhanVien, KhachHang khachHang) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDateTime thoiGian) {
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
