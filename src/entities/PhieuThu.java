package entities;

import java.util.Objects;
import java.sql.Timestamp;

/**
 *
 * @author atuandev
 */
public class PhieuThu {

    private String id;
    private Timestamp thoiGian;
    private NhanVien nhanVien;
    private NhaCungCap nxs;

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

    public NhaCungCap getNxs() {
        return nxs;
    }

    public void setNxs(NhaCungCap nxs) {
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
