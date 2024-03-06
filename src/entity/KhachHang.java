package entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author atuandev
 */
public class KhachHang {

    private String id;
    private String hoTen;
    private String sdt;
    private String gioiTinh;
    private Date ngayThamGia;

    public KhachHang() {
    }

    public KhachHang(String id) {
        this.id = id;
    }

    public KhachHang(String id, String hoTen, String sdt, String gioiTinh, Date ngayThamGia) {
        this.id = id;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.ngayThamGia = ngayThamGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgayThamGia() {
        return ngayThamGia;
    }

    public void setNgayThamGia(Date ngayThamGia) {
        this.ngayThamGia = ngayThamGia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final KhachHang other = (KhachHang) obj;
        return true;
    }

    @Override
    public String toString() {
        return hoTen;
    }

}
