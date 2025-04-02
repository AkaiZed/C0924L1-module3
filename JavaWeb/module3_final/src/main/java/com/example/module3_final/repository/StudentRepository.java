package com.example.module3_final.repository;

import com.example.module3_final.model.Students;
import com.example.module3_final.service.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public List<Students> findAll() {
        List<Students> studentsList = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection connection = ConnectDB.getConnectDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String maHocSinh = resultSet.getString("maHocSinh");
                String hoTen = resultSet.getString("hoTen");
                String lop = resultSet.getString("lop");

                Students student = new Students(maHocSinh, hoTen, lop);
                studentsList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    public List<Students> getAll() {
        return findAll();
    }

    public Students getById(String maHocSinh) {
        Students student = null;
        String query = "SELECT * FROM students WHERE maHocSinh = ?";
        try (Connection connection = ConnectDB.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, maHocSinh);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String hoTen = resultSet.getString("hoTen");
                    String lop = resultSet.getString("lop");
                    student = new Students(maHocSinh, hoTen, lop);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}