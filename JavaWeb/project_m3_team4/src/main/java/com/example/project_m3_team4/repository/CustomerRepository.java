package com.example.project_m3_team4.repository;

import com.example.project_m3_team4.data.ConnectDB;
import com.example.project_m3_team4.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    public boolean addNguoiDung(Customer customer) {
        String sql = "INSERT INTO nguoi_dung (tai_khoan, mat_khau, email, so_dt, dob, dia_chi) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectDB.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getTaiKhoan());
            stmt.setString(2, customer.getMatKhau());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getSoDt());
            stmt.setDate(5, new java.sql.Date(customer.getDob().getTime()));
            stmt.setString(6, customer.getDiaChi());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Customer getNguoiDungByTaiKhoan(String taiKhoan) {
        String sql = "SELECT * FROM nguoi_dung WHERE tai_khoan = ?";
        try (Connection conn = ConnectDB.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, taiKhoan);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getString("tai_khoan"),
                        rs.getString("mat_khau"),
                        rs.getString("email"),
                        rs.getString("so_dt"),
                        rs.getDate("dob"),
                        rs.getString("dia_chi")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Customer> getAllNguoiDung() {
        List<Customer> customerList = new ArrayList<>();
        String sql = "SELECT * FROM nguoi_dung";
        try (Connection conn = ConnectDB.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getString("tai_khoan"),
                        rs.getString("mat_khau"),
                        rs.getString("email"),
                        rs.getString("so_dt"),
                        rs.getDate("dob"),
                        rs.getString("dia_chi")
                );
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}