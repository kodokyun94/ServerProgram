package com.busanit501.sampleserver.connectTest.menu;

import com.busanit501.sampleserver.connectTest.menu.dto.MenuDTO;
import com.busanit501.sampleserver.connectTest.menu.service.MenuService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "MenuController2", urlPatterns = "/menu/list")
public class MenuController2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MenuDTO> sampleList =MenuService.INSTANCE.getList();
        req.setAttribute("list",sampleList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher
                ("/WEB-INF/menu/menuList.jsp" );
        requestDispatcher.forward(req,resp);
    }
}
