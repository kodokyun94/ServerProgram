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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@Log4j2
@WebServlet (name = "MenuController", urlPatterns = "/menu/input")
public class MenuInputController extends HttpServlet {
    private MenuService menuService = MenuService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //조회
        if(session.isNew()){
            log.info("new JsessionID : 새로운 유저" );
            resp.sendRedirect("/login-menu");
            return;
        }

        if(session.getAttribute("loginInfo") == null){
            log.info("로그인 정보가 없는 유저 ");
            resp.sendRedirect("/login-menu");
            return;
        }

        //todo 글 입력 폼
        //화면 입력 폼
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/menuInput.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MenuDTO menuDTO = MenuDTO.builder()
                .menuTitle(req.getParameter("menuTitle"))
                .menuRegDate(LocalDate.parse(req.getParameter("menuRegDate")))
                .build();

        //등록
        try {
            menuService.register(menuDTO);
            resp.sendRedirect("/menu/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
