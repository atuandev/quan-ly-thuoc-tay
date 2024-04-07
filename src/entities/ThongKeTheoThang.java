package entities;

/**
 *
 * @author HP
 */
public class ThongKeTheoThang {
    private int thang;
    private double doanhThu;
    private double chiPhi;

    public ThongKeTheoThang() {
    }

    public ThongKeTheoThang(int thang, double doanhThu, double chiPhi) {
        this.thang = thang;
        this.doanhThu = doanhThu;
        this.chiPhi = chiPhi;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(double chiPhi) {
        this.chiPhi = chiPhi;
    }

    @Override
    public String toString() {
        return "ThongKeChiTiet{" + "thang=" + thang + ", doanhThu=" + doanhThu + ", chiPhi=" + chiPhi + '}';
    }
    
    public double getLoiNhuan() {
        return this.doanhThu - this.chiPhi;
    }
}
