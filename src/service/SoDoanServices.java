/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import getconnect.ConnectSQL;
import define.User;
import getconnect.ConnectSQL;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class SoDoanServices {
    public List<User> getAllUser(){
        List<User> users = new ArrayList<User>();
        Connection con = ConnectSQL.getConnectSQL();
        String sql = "Select * from DoanVien";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                User newUser = new User();
                
                newUser.setIdDoanVien(rs.getString("idDoanVien"));
                newUser.setTenDoanVien(rs.getString("tenDoanVien"));
                newUser.setMaSinhVien(rs.getString("maSinhVien"));
                newUser.setDoB(rs.getString("dob"));
                newUser.setQueQuan(rs.getString("queQuan"));
                newUser.setTenLop(rs.getString("tenLop"));
                newUser.setTenKhoa(rs.getString("tenKhoa"));
                newUser.setTienCanNop(rs.getDouble("tienCanNop"));
                newUser.setTienDaNop(rs.getDouble("tienĐaNop"));
                newUser.setTinhTrangSoDoan(rs.getString("tinhTrangSoDoan"));
                
                users.add(newUser);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi tại getALlUser");
        }
    return users;
    }
    public List<User> getAllUser_tinhTrang(String tinhTrang){
        List<User> users = new ArrayList<User>();
        Connection con = ConnectSQL.getConnectSQL();
        String sql = "";
        if(tinhTrang.equals("Đã nộp"))
        {
            sql = "Select * from DoanVien where tinhTrangSoDoan = N'Đã nộp'";
        }
        else
        {
            sql = "Select * from DoanVien where tinhTrangSoDoan = N'Chưa nộp'";
        }
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                User newUser = new User();
                
                newUser.setIdDoanVien(rs.getString("idDoanVien"));
                newUser.setTenDoanVien(rs.getString("tenDoanVien"));
                newUser.setMaSinhVien(rs.getString("maSinhVien"));
                newUser.setDoB(rs.getString("dob"));
                newUser.setQueQuan(rs.getString("queQuan"));
                newUser.setTenLop(rs.getString("tenLop"));
                newUser.setTenKhoa(rs.getString("tenKhoa"));
                newUser.setTienCanNop(rs.getDouble("tienCanNop"));
                newUser.setTienDaNop(rs.getDouble("tienĐaNop"));
                newUser.setTinhTrangSoDoan(rs.getString("tinhTrangSoDoan"));
                
                users.add(newUser);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi tại getALlUser_tinhTrangSoDoan");
        }
    return users;
    }
    public void addUser(User user){
        Connection con = ConnectSQL.getConnectSQL();
        String sql = "Insert into DoanVien(idDoanVien,tenDoanVien,maSinhVien,doB,queQuan,tenLop,tenKhoa,tienCanNop,tienDaNop,tinhTrangSoDoan)"
                + "values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getIdDoanVien());
            preparedStatement.setString(2, user.getTenDoanVien());
            preparedStatement.setString(3, user.getMaSinhVien());
            preparedStatement.setString(4, user.getDoB());
            preparedStatement.setString(5, user.getQueQuan());
            preparedStatement.setString(6, user.getTenLop());
            preparedStatement.setString(7, user.getTenKhoa());
            preparedStatement.setDouble(8, user.getTienCanNop());
            preparedStatement.setDouble(9, user.getTienDaNop());
            preparedStatement.setString(10, user.getTinhTrangSoDoan());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Lỗi tại Add");
        }
    }
    public void deleteUser(String idDoanVien){
        Connection con = ConnectSQL.getConnectSQL();
        String sql = "Delete from DoanVien where idDoanVien = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, idDoanVien);
            
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Lỗi tại DeleteUser");
        }
    }
    public static String getIdNext(){
        Connection con = ConnectSQL.getConnectSQL();
        String sql = "select dbo.FN_getidDoanVien()";
        String idNext = null;
        try{
            PreparedStatement preparedStatement = con.prepareCall(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next())
            {
                idNext = rs.getString("");
            }
            return idNext;
        }
        catch(SQLException e)
        {
            e.printStackTrace();;
        }
        return idNext;
    }
}
