package com.busanit501.sampleserver.connectTest.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController2", urlPatterns = "/login-result")
public class LoginController2 extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("login-result post로 받기");
        String id = req.getParameter("mid");
        String pw = req.getParameter("mpw");

        if (id.equals("lsy") && pw.equals("1234")) {
            // 메인, index 로가기.
            System.out.println("로그인 성공후 메인으로 가기. ");
            resp.sendRedirect("/");
        } else {
            // 실패면, 로그인 폼으로 가기.
            resp.sendRedirect("/login");
        }
    }
}
