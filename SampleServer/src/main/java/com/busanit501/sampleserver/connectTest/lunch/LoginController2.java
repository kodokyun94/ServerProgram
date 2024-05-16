package com.busanit501.sampleserver.connectTest.lunch;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "lunchController2", urlPatterns = "/lunch-result")
public class LoginController2 extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("lunch-result post 받기");
        String lunch = req.getParameter("mlunch");

        if (lunch.equals("맥도날드") ) {
            // 메인, index 로가기.
            System.out.println("정답 입력 ");
            resp.sendRedirect("/index.jsp");
        } else {
            // 실패면, 로그인 폼으로 가기.
            resp.sendRedirect("/lunch");
        }
    }
}
