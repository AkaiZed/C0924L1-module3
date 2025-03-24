package com.example.project_m3_team4.data;

import com.example.project_m3_team4.model.NguoiDung;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {

    public boolean addNguoiDung(NguoiDung nguoiDung) {
        String sql = "INSERT INTO nguoi_dung (tai_khoan, mat_khau, email, so_dt, dob, dia_chi) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectDB.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nguoiDung.getTaiKhoan());
            stmt.setString(2, nguoiDung.getMatKhau());
            stmt.setString(3, nguoiDung.getEmail());
            stmt.setString(4, nguoiDung.getSoDt());
            stmt.setDate(5, new java.sql.Date(nguoiDung.getDob().getTime()));
            stmt.setString(6, nguoiDung.getDiaChi());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public NguoiDung getNguoiDungByTaiKhoan(String taiKhoan) {
        String sql = "SELECT * FROM nguoi_dung WHERE tai_khoan = ?";
        try (Connection conn = ConnectDB.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, taiKhoan);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new NguoiDung(
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

    public List<NguoiDung> getAllNguoiDung() {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String sql = "SELECT * FROM nguoi_dung";
        try (Connection conn = ConnectDB.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                NguoiDung nguoiDung = new NguoiDung(
                        rs.getString("tai_khoan"),
                        rs.getString("mat_khau"),
                        rs.getString("email"),
                        rs.getString("so_dt"),
                        rs.getDate("dob"),
                        rs.getString("dia_chi")
                );
                nguoiDungList.add(nguoiDung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nguoiDungList;
    }
}