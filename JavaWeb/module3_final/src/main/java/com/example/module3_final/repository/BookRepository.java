package com.example.module3_final.repository;

import com.example.module3_final.model.Books;
import com.example.module3_final.service.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    public List<Books> findAll() {
        List<Books> booksList = new ArrayList<>();
        String query = "SELECT * FROM books";
        try (Connection connection = ConnectDB.getConnectDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String maSach = resultSet.getString("maSach");
                String tenSach = resultSet.getString("tenSach");
                String tacGia = resultSet.getString("tacGia");
                int soLuong = resultSet.getInt("soLuong");
                String moTa = resultSet.getString("moTa");

                Books book = new Books(maSach, tenSach, tacGia, soLuong, moTa);
                booksList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booksList;
    }

    public List<Books> getAll() {
        return findAll();
    }

    public List<Books> searchBook(String keyword) {
        List<Books> booksList = new ArrayList<>();
        String query = "SELECT * FROM books WHERE tenSach LIKE ? OR tacGia LIKE ?";
        try (Connection connection = ConnectDB.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            String searchKeyword = "%" + keyword + "%";
            preparedStatement.setString(1, searchKeyword);
            preparedStatement.setString(2, searchKeyword);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String maSach = resultSet.getString("maSach");
                    String tenSach = resultSet.getString("tenSach");
                    String tacGia = resultSet.getString("tacGia");
                    int soLuong = resultSet.getInt("soLuong");
                    String moTa = resultSet.getString("moTa");

                    Books book = new Books(maSach, tenSach, tacGia, soLuong, moTa);
                    booksList.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booksList;
    }

    public Books getBookById(String maSach) {
        Books book = null;
        String query = "SELECT * FROM books WHERE maSach = ?";
        try (Connection connection = ConnectDB.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, maSach);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String tenSach = resultSet.getString("tenSach");
                    String tacGia = resultSet.getString("tacGia");
                    int soLuong = resultSet.getInt("soLuong");
                    String moTa = resultSet.getString("moTa");
                    book = new Books(maSach, tenSach, tacGia, soLuong, moTa);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public void updateBookQuantity(String maSach) {
        String query = "UPDATE books SET soLuong = soLuong - 1 WHERE maSach = ?";
        try (Connection connection = ConnectDB.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, maSach);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}