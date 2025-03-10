package com.example.ss10_hien_thi_danh_sach.controller;

import com.example.ss10_hien_thi_danh_sach.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    public static final List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer("Mai Văn Hoàn", LocalDate.parse("1983-08-20"), "Hà Nội", "anh/anh1.png"));
        customerList.add(new Customer("Nguyễn Văn Nam", LocalDate.parse("1983-08-21"), "Bắc Giang", "anh/anh2.jpg"));
        customerList.add(new Customer("Nguyễn Thái Hòa", LocalDate.parse("1983-08-22"), "Nam Định", "anh/anh3.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa", LocalDate.parse("1983-08-17"), "Hà Tây", "anh/anh4.png"));
        customerList.add(new Customer("Nguyễn Đình Thi", LocalDate.parse("1983-08-19"), "Hà Nội", "anh/anh5.jpg"));
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customerList", customerList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
