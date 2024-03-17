package entities;

/**
 *
 * @author HP
 */
public class VaiTro {

    private String id;
    private String ten;

    public VaiTro() {
    }

    public VaiTro(String id) {
        this.id = id;
    }

    public VaiTro(String id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return ten;
    }

}
