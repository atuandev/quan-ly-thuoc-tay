package entity;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author atuandev
 */
public class PhieuDatHang {

    private String id;
    private LocalDateTime thoiGian;
    private KhachHang khachHang;
    private String diaChi;
    private String hinhThucThanhToan;
    private String trangThai;

    public PhieuDatHang() {
    }

    public PhieuDatHang(String id) {
        this.id = id;
    }

    public PhieuDatHang(String id, LocalDateTime thoiGian, KhachHang khachHang, String diaChi, String hinhThucThanhToan, String trangThai) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.khachHang = khachHang;
        this.diaChi = diaChi;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.trangThai = trangThai;
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

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final PhieuDatHang other = (PhieuDatHang) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "PhieuDatHang{" + "id=" + id + ", thoiGian=" + thoiGian + ", khachHang=" + khachHang + ", diaChi=" + diaChi + ", hinhThucThanhToan=" + hinhThucThanhToan + ", trangThai=" + trangThai + '}';
    }

}
