package entities;

/**
 *
 * @author HP
 */
public class ThongKeTheoNam {
    private int nam;
    private double doanhThu;
    private double chiPhi;

    public ThongKeTheoNam() {
    }

    public ThongKeTheoNam(int nam, double doanhThu, double chiPhi) {
        this.nam = nam;
        this.doanhThu = doanhThu;
        this.chiPhi = chiPhi;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
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
        return "ThongKeChiTiet{" + "nam=" + nam + ", doanhThu=" + doanhThu + ", chiPhi=" + chiPhi + '}';
    }
    
    public double getLoiNhuan() {
        return this.doanhThu - this.chiPhi;
    }
}
