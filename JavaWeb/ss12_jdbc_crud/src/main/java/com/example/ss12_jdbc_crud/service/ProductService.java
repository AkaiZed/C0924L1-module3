package com.example.ss12_jdbc_crud.service;

import com.example.ss12_jdbc_crud.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static Connection getConnection() throws SQLException {
        return ConnectDB.getConnectDB();
    }

    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product_data";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int count = resultSet.getInt("count");

                products.add(new Product(id, name, price, count));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void deleteById(int id) {
        String sql = "DELETE FROM product_data WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Product findById(int id) {
        Product product = null;
        String sql = "SELECT * FROM product_data WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("count")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static void update(int id, Product updatedProduct) {
        String sql = "UPDATE product_data SET name = ?, price = ?, count = ? WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, updatedProduct.getName());
            preparedStatement.setDouble(2, updatedProduct.getPrice());
            preparedStatement.setInt(3, updatedProduct.getCount());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addProduct(Product newProduct) {
        String sql = "INSERT INTO product_data (id, name, price, count) VALUES (?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, newProduct.getId());
            preparedStatement.setString(2, newProduct.getName());
            preparedStatement.setDouble(3, newProduct.getPrice());
            preparedStatement.setInt(4, newProduct.getCount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
