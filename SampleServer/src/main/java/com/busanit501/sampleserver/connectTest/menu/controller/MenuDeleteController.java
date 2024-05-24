package com.busanit501.sampleserver.connectTest.menu.controller;

import com.busanit501.sampleserver.connectTest.menu.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="menudelete", urlPatterns = "/menu/delete")
public class MenuDeleteController extends HttpServlet {
    private MenuService menuService = MenuService.INSTANCE;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long menuNo = Long.valueOf(req.getParameter("menuNo"));

        try {
            menuService.deleteMenu(menuNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/menu/list");

    }
}
