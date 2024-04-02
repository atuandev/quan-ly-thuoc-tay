package entities;

import java.util.Objects;
import java.sql.Timestamp;

/**
 *
 * @author atuandev
 */
public class PhieuNhap {

    private String id;
    private Timestamp thoiGian;
    private NhanVien nhanVien;
    private NhaCungCap ncc;
    private double tongTien;

    public PhieuNhap() {
    }

    public PhieuNhap(String id, Timestamp thoiGian, NhanVien nhanVien, NhaCungCap ncc, double tongTien) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.nhanVien = nhanVien;
        this.ncc = ncc;
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

    public NhaCungCap getNcc() {
        return ncc;
    }

    public void setNcc(NhaCungCap ncc) {
        this.ncc = ncc;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
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
        final PhieuNhap other = (PhieuNhap) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "PhieuNhap{" + "id=" + id + ", thoiGian=" + thoiGian + ", nhanVien=" + nhanVien + ", ncc=" + ncc + ", tongTien=" + tongTien + '}';
    }

}
