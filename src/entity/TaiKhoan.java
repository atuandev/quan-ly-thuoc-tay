package entity;

/**
 *
 * @author Atuandev
 */
public class TaiKhoan {

    private String username;
    private String password;
    private NhanVien nhanVien;
    private PhanQuyen phanQuyen;

    public TaiKhoan() {
    }

    public TaiKhoan(String username) {
        this.username = username;
    }

    public TaiKhoan(String username, String password, NhanVien nhanVien, PhanQuyen phanQuyen) {
        this.username = username;
        this.password = password;
        this.nhanVien = nhanVien;
        this.phanQuyen = phanQuyen;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public PhanQuyen getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(PhanQuyen phanQuyen) {
        this.phanQuyen = phanQuyen;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "username=" + username + ", password=" + password + ", nhanVien=" + nhanVien + ", phanQuyen=" + phanQuyen + '}';
    }

}
