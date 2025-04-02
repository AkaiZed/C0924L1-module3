package com.example.module3_final.controller;

import com.example.module3_final.model.Cards;
import com.example.module3_final.repository.BookRepository;
import com.example.module3_final.repository.CardRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BorrowController", value = "/BorrowController")
public class BorrowController extends HttpServlet {
    private CardRepository cardRepository = new CardRepository();
    private BookRepository bookRepository = new BookRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maMuonSach = request.getParameter("maMuonSach");
        String maSach = request.getParameter("maSach");
        String maHocSinh = request.getParameter("maHocSinh");
        String ngayMuon = request.getParameter("ngayMuon");
        String ngayTra = request.getParameter("ngayTra");

        Cards card = new Cards(maMuonSach, maSach, maHocSinh, true, ngayMuon, ngayTra);
        cardRepository.addCard(card);

        bookRepository.updateBookQuantity(maSach);

        response.sendRedirect("BorrowListController");
    }
}