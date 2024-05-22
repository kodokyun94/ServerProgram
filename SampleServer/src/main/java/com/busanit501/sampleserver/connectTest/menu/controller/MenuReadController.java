package com.busanit501.sampleserver.connectTest.menu.controller;

import com.busanit501.sampleserver.connectTest.menu.dto.MenuDTO;
import com.busanit501.sampleserver.connectTest.menu.service.MenuService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Log4j2
@WebServlet(name = "menuRead", urlPatterns = "/menu/read")
public class MenuReadController extends HttpServlet {
    private MenuService menuService = MenuService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long menuNo = Long.valueOf(req.getParameter("menuNo"));
            MenuDTO sample = menuService.getSelectOne(menuNo);
            log.info("MenuListController 확인2 sample" + sample);
            req.setAttribute("sample",sample);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/menuRead.jsp");
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

    }
}
