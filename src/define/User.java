/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package define;

/**
 *
 * @author pc
 */
public class User {
    private String idDoanVien;
    private String tenDoanVien;
    private String maSinhVien;  
    private String doB;
    private String queQuan;
    private String tenLop;
    private String tenKhoa;
    private double tienCanNop;
    private double tienDaNop;
    private String tinhTrangSoDoan;


    public User() {
    }


    public User(String idDoanVien, String tenDoanVien, String maSinhVien, String doB, String queQuan, String tenLop, String tenKhoa, double tienCanNop, double tienDaNop, String tinhTrangSoDoan) {
        this.idDoanVien = idDoanVien;
        this.tenDoanVien = tenDoanVien;
        this.maSinhVien = maSinhVien;
        this.doB = doB;
        this.queQuan = queQuan;
        this.tenLop = tenLop;
        this.tenKhoa = tenKhoa;
        this.tienCanNop = tienCanNop;
        this.tienDaNop = tienDaNop;
        this.tinhTrangSoDoan = tinhTrangSoDoan;
    }
    
    

    public String getIdDoanVien() {
        return idDoanVien;
    }

    public void setIdDoanVien(String idDoanVien) {
        this.idDoanVien = idDoanVien;
    }

    public String getTenDoanVien() {
        return tenDoanVien;
    }

    public void setTenDoanVien(String tenDoanVien) {
        this.tenDoanVien = tenDoanVien;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public double getTienCanNop() {
        return tienCanNop;
    }

    public void setTienCanNop(double tienCanNop) {
        this.tienCanNop = tienCanNop;
    }

    public double getTienDaNop() {
        return tienDaNop;
    }

    public void setTienDaNop(double tienDaNop) {
        this.tienDaNop = tienDaNop;
    }

    public String getTinhTrangSoDoan() {
        return tinhTrangSoDoan;
    }

    public void setTinhTrangSoDoan(String tinhTrangSoDoan) {
        this.tinhTrangSoDoan = tinhTrangSoDoan;
    }

    
    
}
