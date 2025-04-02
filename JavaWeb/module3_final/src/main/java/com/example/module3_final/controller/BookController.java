package com.example.module3_final.controller;

import com.example.module3_final.model.Books;
import com.example.module3_final.repository.BookRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookController", value = "/BookController")
public class BookController extends HttpServlet {
    private BookRepository bookRepository = new BookRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Books> booksList = bookRepository.getAll();

        String keyword = request.getParameter("keyword");
        if (keyword != null && !keyword.isEmpty()) {
            booksList = bookRepository.searchBook(keyword);
        }

        request.setAttribute("booksList", booksList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("showList.jsp");
        dispatcher.forward(request, response);
    }
}