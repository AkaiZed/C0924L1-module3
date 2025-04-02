package com.example.module3_final.repository;

import com.example.module3_final.model.Cards;
import com.example.module3_final.service.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardRepository {

    public void addCard(Cards card) {
        String query = "INSERT INTO cards (maMuonSach, maSach, maHocSinh, trangThai, ngayMuon, ngayTra) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDB.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, card.getMaMuonSach());
            preparedStatement.setString(2, card.getMaSach());
            preparedStatement.setString(3, card.getMaHocSinh());
            preparedStatement.setBoolean(4, card.isTrangThai());
            preparedStatement.setString(5, card.getNgayMuon());
            preparedStatement.setString(6, card.getNgayTra());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cards> getAllCards() {
        List<Cards> cardsList = new ArrayList<>();
        String query = "SELECT c.maMuonSach, c.maSach, b.tenSach, c.maHocSinh, s.hoTen, c.trangThai, c.ngayMuon, c.ngayTra " +
                "FROM cards c " +
                "JOIN books b ON c.maSach = b.maSach " +
                "JOIN students s ON c.maHocSinh = s.maHocSinh " +
                "WHERE c.trangThai = TRUE";
        try (Connection connection = ConnectDB.getConnectDB();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String maMuonSach = resultSet.getString("maMuonSach");
                String maSach = resultSet.getString("maSach");
                String tenSach = resultSet.getString("tenSach");
                String maHocSinh = resultSet.getString("maHocSinh");
                String hoTen = resultSet.getString("hoTen");
                boolean trangThai = resultSet.getBoolean("trangThai");
                String ngayMuon = resultSet.getString("ngayMuon");
                String ngayTra = resultSet.getString("ngayTra");

                Cards card = new Cards(maMuonSach, maSach, maHocSinh, trangThai, ngayMuon, ngayTra);
                card.setTenSach(tenSach);
                card.setTenHocSinh(hoTen);
                cardsList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardsList;
    }

    public Cards getCardById(String maMuonSach) {
        Cards card = null;
        String query = "SELECT c.maMuonSach, c.maSach, b.tenSach, c.maHocSinh, s.hoTen, c.trangThai, c.ngayMuon, c.ngayTra " +
                "FROM cards c " +
                "JOIN books b ON c.maSach = b.maSach " +
                "JOIN students s ON c.maHocSinh = s.maHocSinh " +
                "WHERE c.maMuonSach = ?";
        try (Connection connection = ConnectDB.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, maMuonSach);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String maSach = resultSet.getString("maSach");
                String tenSach = resultSet.getString("tenSach");
                String maHocSinh = resultSet.getString("maHocSinh");
                String hoTen = resultSet.getString("hoTen");
                boolean trangThai = resultSet.getBoolean("trangThai");
                String ngayMuon = resultSet.getString("ngayMuon");
                String ngayTra = resultSet.getString("ngayTra");

                card = new Cards(maMuonSach, maSach, maHocSinh, trangThai, ngayMuon, ngayTra);
                card.setTenSach(tenSach);
                card.setTenHocSinh(hoTen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }
}