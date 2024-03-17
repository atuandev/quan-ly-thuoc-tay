package entities;

/**
 *
 * @author Atuandev
 */
public class TaiKhoan {

    private String id;
    private String username;
    private String password;
    private NhanVien nhanVien;
    private VaiTro vaiTro;

    public TaiKhoan() {
    }

    public TaiKhoan(String id) {
        this.id = id;
    }

    public TaiKhoan(String id, String username, String password, NhanVien nhanVien, VaiTro vaiTro) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nhanVien = nhanVien;
        this.vaiTro = vaiTro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public VaiTro getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(VaiTro vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        return username;
    }

}
