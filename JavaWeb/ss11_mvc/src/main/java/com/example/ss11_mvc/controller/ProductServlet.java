package com.example.ss11_mvc.controller;

import com.example.ss11_mvc.model.Product;
import com.example.ss11_mvc.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                formAdd(req, resp);
                break;
            case "edit":
                editProduct(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            case "details":
                break;
            case "find":
                break;
            default:
                showProduct(req, resp);
        }
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = ProductService.findById(id);

        if (product != null) {
            req.setAttribute("product", product);
            req.getRequestDispatcher("/view/edit.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/products");
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Product> products = ProductService.getProducts();
        products.removeIf(product -> product.getId() == id);
        resp.sendRedirect("/products");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addProduct(req, resp);
                break;
            case "edit":
                updateProduct(req, resp);
                break;
            default:
                showProduct(req, resp);
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            int count = Integer.parseInt(req.getParameter("count"));

            Product product = new Product(id, name, price, count);
            ProductService.update(id, product);
            resp.sendRedirect("/products");
        } catch (Exception e) {
            req.setAttribute("error", "An error occurred while updating the product. Please try again.");
            req.getRequestDispatcher("/view/edit.jsp").forward(req, resp);
        }
    }


    private void formAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/add.jsp").forward(req, resp);
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            int count = Integer.parseInt(req.getParameter("count"));

            Product newProduct = new Product(id, name, price, count);
            ProductService.getProducts().add(newProduct);
            resp.sendRedirect("/products");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid input. Please enter valid numbers for ID, price, and count.");
            req.getRequestDispatcher("/view/add.jsp").forward(req, resp);
        }
    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductService.getProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/view/product.jsp").forward(req, resp);
    }
}