package entity;

/**
 *
 * @author atuandev
 */
public class PhieuThu {

    private String id;
    private String thoiGian;
    private NhanVien nhanVien;
    private NhaSanXuat nxs;
    private double tongTien;

    public PhieuThu(String id, String thoiGian, NhanVien nhanVien, NhaSanXuat nxs, double tongTien) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.nhanVien = nhanVien;
        this.nxs = nxs;
        this.tongTien = tongTien;
    }

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

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
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

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "PhieuThu{" + "id=" + id + ", thoiGian=" + thoiGian + ", nhanVien=" + nhanVien + ", nxs=" + nxs + ", tongTien=" + tongTien + '}';
    }

}
