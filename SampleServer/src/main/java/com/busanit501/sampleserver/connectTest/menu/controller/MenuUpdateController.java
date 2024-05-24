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
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "MenuUpdate",urlPatterns = "/menu/update")
public class MenuUpdateController extends HttpServlet {
    private MenuService menuService = MenuService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long menuNo = Long.valueOf(req.getParameter("menuNo"));
            MenuDTO sample = menuService.getSelectOne(menuNo);
            log.info("MenuListController 확인2 sample" + sample);
            req.setAttribute("sample",sample);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/menuUpd.jsp");
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long menuNo = Long.valueOf(req.getParameter("menuNo"));
        log.info("menuNo 확인 중 : " + menuNo);
        String menuTitle = req.getParameter("menuTitle");
        log.info("menuTitle 확인 중 2 : " + menuTitle);
        LocalDate localDate =LocalDate.parse(req.getParameter("menuRegDate")) ;
        log.info("menuRegDate 확인 중 3 : " + localDate);

        MenuDTO menuDTO = MenuDTO.builder()
                .menuTitle(menuTitle)
                .menuRegDate(localDate)
                .menuNo(menuNo)
                .build();

        try {
            menuService.updateMenu(menuDTO);
            resp.sendRedirect("/menu/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
