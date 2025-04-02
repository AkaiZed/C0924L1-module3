package com.example.module3_final.controller;

import com.example.module3_final.model.Books;
import com.example.module3_final.model.Students;
import com.example.module3_final.repository.BookRepository;
import com.example.module3_final.repository.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookDetailController", value = "/borrow")
public class BookDetailController extends HttpServlet {
    private BookRepository bookRepository = new BookRepository();
    private StudentRepository studentRepository = new StudentRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSach = request.getParameter("maSach");

        Books book = bookRepository.getBookById(maSach);

        if (book == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Sách không tồn tại");
            return;
        }

        List<Students> studentsList = studentRepository.getAll();

        java.util.Date date = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(date);

        request.setAttribute("book", book);
        request.setAttribute("studentsList", studentsList);
        request.setAttribute("currentDate", currentDate);

        request.getRequestDispatcher("/borrow.jsp").forward(request, response);
    }
}