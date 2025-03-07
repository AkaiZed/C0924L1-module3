package ss9_tong_quan_java_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountSeverlet", value = "/sum")
public class DiscountSeverlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int listPrice = Integer.parseInt(request.getParameter("listPrice"));
        float discountPercent = Float.parseFloat(request.getParameter("discountPercent"));

        float discountAmount = (float) (listPrice * discountPercent * 0.01);

        request.setAttribute("discountAmount", discountAmount);
        request.getRequestDispatcher("Output.jsp").forward(request, response);

    }
}
