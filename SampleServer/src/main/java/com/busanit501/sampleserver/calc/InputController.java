package com.busanit501.sampleserver.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "inputController", urlPatterns = "/calc/input")
public class InputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("작업순서1 : InputController 거쳐가기. ");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher
                ("/WEB-INF/calc/input.jsp" );
        requestDispatcher.forward(req,resp);
    }
}
