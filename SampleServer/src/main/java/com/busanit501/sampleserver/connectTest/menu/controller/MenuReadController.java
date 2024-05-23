package com.busanit501.sampleserver.connectTest.menu.controller;

import com.busanit501.sampleserver.connectTest.menu.dto.MenuDTO;
import com.busanit501.sampleserver.connectTest.menu.service.MenuService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
            // db에서 가져오기
            Long menuNo = Long.valueOf(req.getParameter("menuNo"));
            MenuDTO sample = menuService.getSelectOne(menuNo);

            log.info("MenuListController , 확인2, sample : " + sample);

            // 화면에 전달하기.
            req.setAttribute("sample", sample);

            // 쿠키 찾기.
            // findCookie 메서드, 첫번째 파라미터 : 쿠키의 전체 목록,
            // 두번 째 파라미터 , 내가 찾고자하는 쿠키의 키 이름.
            Cookie viewMenuCookie = findCookie(req.getCookies(), "viewMenus");
            String menuListResult = viewMenuCookie.getValue();
            boolean exist = false;

            // str = "hello", str.indexOf("e")
            // tno+"-" => 1-3-5
            if (menuListResult != null && menuListResult.indexOf(menuNo + "-") >= 0) {
                exist = true;
            }

            //exist 가 false 이면 동작함.
            if (!exist) {
                menuListResult += menuNo + "-";
                viewMenuCookie.setValue(menuListResult);
                viewMenuCookie.setMaxAge(60 * 60 * 24);
                viewMenuCookie.setPath("/");
                resp.addCookie(viewMenuCookie);
            }
            req.getRequestDispatcher("/WEB-INF/menu/menuRead.jsp")
                    .forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Cookie findCookie(Cookie[] cookies, String cookieName) {
        // 찾은 쿠키를 담을 임시 쿠기.
        Cookie targetCookie = null;

        if(cookies != null && cookies.length >0) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals(cookieName)){
                    targetCookie = cookie;
                    break;
                }
            }
        } // if 조건문

        if(targetCookie == null) {
            targetCookie = new Cookie(cookieName,"");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60*60*24);

        }
        return targetCookie;
    } // findCookie 닫는 부분
}
