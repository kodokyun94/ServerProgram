package com.busanit501.sampleserver.connectTest.menu.controller;

import com.busanit501.sampleserver.connectTest.menu.dto.MenuDTO;
import com.busanit501.sampleserver.connectTest.menu.dto.MenuMemberDTO;
import com.busanit501.sampleserver.connectTest.menu.service.MenuMemberService;
import com.busanit501.sampleserver.connectTest.menu.service.MenuService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet (name = "MenuController2", urlPatterns = "/menu/list")
public class MenuListController extends HttpServlet {
    private MenuService menuService = MenuService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        MenuMemberDTO noAutoLoginmemberDTO = (MenuMemberDTO) session.getAttribute("loginInfo");
        //MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginInfo");
        log.info("Login info 세션의 정보 get하기.: " + noAutoLoginmemberDTO);
        String mid = noAutoLoginmemberDTO.getMid();
        String mpw = noAutoLoginmemberDTO.getMpw();
        MenuMemberDTO menuMemberDTO = null;
        try {
            menuMemberDTO = MenuMemberService.INSTANCE.getSelectOneMember(mid, mpw);
            List<MenuDTO> sampleList = null;
            sampleList = menuService.INSTANCE.listAll();
//            log.info("TodoListController 확인2" + sampleList);
            req.setAttribute("list",sampleList);
            req.setAttribute("memberDTO",menuMemberDTO);
            req.getRequestDispatcher("/WEB-INF/menu/menuList.jsp")
                    .forward(req, resp);
        } catch (Exception e) {


            throw new RuntimeException(e);
        }
    }
}
