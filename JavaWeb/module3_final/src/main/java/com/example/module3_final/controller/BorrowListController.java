package com.example.module3_final.controller;

import com.example.module3_final.model.Cards;
import com.example.module3_final.repository.CardRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BorrowListController", value = "/BorrowListController")
public class BorrowListController extends HttpServlet {
    private CardRepository cardRepository = new CardRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cards> cardsList = cardRepository.getAllCards();
        request.setAttribute("cardsList", cardsList);
        request.getRequestDispatcher("/borrowList.jsp").forward(request, response);
    }
}