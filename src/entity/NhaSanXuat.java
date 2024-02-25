/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HP
 */
public class NhaSanXuat {
    private String id;
    private String ten;
    private String sdt;
    private String diaChi;

    public NhaSanXuat() {
    }

    public NhaSanXuat(String id) {
        this.id = id;
    }

    public NhaSanXuat(String id, String ten, String sdt, String diaChi) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "NhaSanXuat{" + "id=" + id + ", ten=" + ten + ", sdt=" + sdt + ", diaChi=" + diaChi + '}';
    }
    
    
}
