package entity;

/**
 *
 * @author atuandev
 */
public class HoaDon {

    private String id;
    private String thoiGian;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private double tongTien;
    private double tienKhachDua;
    private double tienThua;

    public HoaDon() {
    }

    public HoaDon(String id) {
        this.id = id;
    }

    public HoaDon(String id, String thoiGian, NhanVien nhanVien, KhachHang khachHang, double tongTien, double tienKhachDua, double tienThua) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.tongTien = tongTien;
        this.tienKhachDua = tienKhachDua;
        this.tienThua = tienThua;
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

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(double tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public double getTienThua() {
        return tienThua;
    }

    public void setTienThua(double tienThua) {
        this.tienThua = tienThua;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", thoiGian=" + thoiGian + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", tongTien=" + tongTien + ", tienKhachDua=" + tienKhachDua + ", tienThua=" + tienThua + '}';
    }

}
