package com.example.project_m3_team4.controller;

import com.example.project_m3_team4.data.ConnectDB;
import com.example.project_m3_team4.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "LoginSeverlet", value = "/LoginSeverlet")
public class LoginSeverlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("taiKhoan");
        String password = request.getParameter("matKhau");

        try (Connection conn = ConnectDB.getConnection()) {
            String sql = "SELECT * FROM users WHERE taiKhoan = ? AND matKhau = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                stmt.setString(2, password);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        User user = new User(
                                rs.getInt("id"),
                                rs.getString("taiKhoan"),
                                rs.getString("matKhau"),
                                rs.getString("email"),
                                rs.getString("soDt"),
                                rs.getDate("dob"),
                                rs.getString("diaChi"),
                                rs.getString("vaiTro")
                        );
                    } else {
                        request.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng!");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi kết nối CSDL: " + e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}


