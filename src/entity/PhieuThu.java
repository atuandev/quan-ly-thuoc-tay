package entity;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author atuandev
 */
public class PhieuThu {

    private String id;
    private LocalDateTime thoiGian;
    private NhanVien nhanVien;
    private NhaSanXuat nxs;

    public PhieuThu() {
    }

    public PhieuThu(String id) {
        this.id = id;
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

    public NhaSanXuat getNxs() {
        return nxs;
    }

    public void setNxs(NhaSanXuat nxs) {
        this.nxs = nxs;
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
        final PhieuThu other = (PhieuThu) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "PhieuThu{" + "id=" + id + ", thoiGian=" + thoiGian + ", nhanVien=" + nhanVien + ", nxs=" + nxs + '}';
    }

}
