package com.example.project_m3_team4.controller;

import com.example.project_m3_team4.repository.CustomerRepository;
import com.example.project_m3_team4.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CustomerController", value = "/CustomerController")
public class CustomerController extends HttpServlet {
    private CustomerRepository customerRepository;

    @Override
    public void init() throws ServletException {
        customerRepository = new CustomerRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "signup":
                request.getRequestDispatcher("/SignUp.jsp").forward(request, response);
                break;
            case "login":
            default:
                request.getRequestDispatcher("/Login.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "signup":
                handleSignup(request, response);
                break;
            case "login":
            default:
                handleLogin(request, response);
                break;
        }
    }

    private void handleSignup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String taiKhoan = request.getParameter("username");
            String matKhau = request.getParameter("password");
            String email = request.getParameter("email");
            String soDt = request.getParameter("phone");
            String dobStr = request.getParameter("birthday");
            String diaChi = ""; // Not provided in the form, can be added later

            // Validate inputs
            if (taiKhoan == null || matKhau == null || soDt == null || dobStr == null) {
                request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin bắt buộc.");
                request.getRequestDispatcher("/SignUp.jsp").forward(request, response);
                return;
            }

            // Check if username already exists
            if (customerRepository.getNguoiDungByTaiKhoan(taiKhoan) != null) {
                request.setAttribute("errorMessage", "Tên đăng nhập đã tồn tại. Vui lòng chọn tên khác.");
                request.getRequestDispatcher("/SignUp.jsp").forward(request, response);
                return;
            }

            // Parse date of birth
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = dateFormat.parse(dobStr);

            // Create new user
            Customer customer = new Customer(taiKhoan, matKhau, email, soDt, dob, diaChi);
            boolean isAdded = customerRepository.addNguoiDung(customer);

            if (isAdded) {
                response.sendRedirect(request.getContextPath() + "/CustomerController?action=login");
            } else {
                request.setAttribute("errorMessage", "Đăng ký thất bại. Vui lòng thử lại.");
                request.getRequestDispatcher("/view/SignUp.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Dữ liệu không hợp lệ. Vui lòng kiểm tra lại.");
            request.getRequestDispatcher("/SignUp.jsp").forward(request, response);
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taiKhoan = request.getParameter("username");
        String matKhau = request.getParameter("password");

        if (taiKhoan == null || matKhau == null) {
            request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin.");
            request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
            return;
        }

        Customer customer = customerRepository.getNguoiDungByTaiKhoan(taiKhoan);
        if (customer != null && customer.getMatKhau().equals(matKhau)) {
            // Successful login
            HttpSession session = request.getSession();
            session.setAttribute("nguoiDung", customer);
            response.sendRedirect(request.getContextPath() + "/TeacherController"); // Redirect to teacher management page
        } else {
            request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng.");
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }
}