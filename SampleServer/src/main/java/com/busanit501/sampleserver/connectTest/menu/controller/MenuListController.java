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
import java.util.List;

@Log4j2
@WebServlet (name = "MenuController2", urlPatterns = "/menu/list")
public class MenuListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MenuDTO> sampleList = null;
        try {
            sampleList = MenuService.INSTANCE.listAll();
            req.setAttribute("list",sampleList);
            log.info("sampleList" + sampleList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher
                    ("/WEB-INF/menu/menuList.jsp" );
            requestDispatcher.forward(req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
