package com.busanit501.sampleserver.connectTest.menu.controller;

import com.busanit501.sampleserver.connectTest.menu.dto.MenuDTO;
import com.busanit501.sampleserver.connectTest.menu.service.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet (name = "MenuController", urlPatterns = "/menu/input")
public class MenuInputController extends HttpServlet {
    private MenuService menuService = MenuService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher
                ("/WEB-INF/menu/menuInput.jsp" );
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MenuDTO menuDTO = MenuDTO.builder()
                .menuTitle(req.getParameter("menuTitle"))
                .menuRegDate(LocalDate.parse(req.getParameter("menuRegDate")))
                .build();
        try {
            menuService.register(menuDTO);
            resp.sendRedirect("/menu/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
