package com.busanit501.sampleserver.connectTest.filter;

import com.busanit501.sampleserver.connectTest.menu.dto.MenuMemberDTO;
import com.busanit501.sampleserver.connectTest.menu.service.MenuMemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Log4j2
@WebFilter (urlPatterns = "/menu/*")
public class LoginFilter2 implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("로그인 필터 동작 여부 확인");

       HttpServletRequest req= (HttpServletRequest)servletRequest;
       HttpServletResponse resp= (HttpServletResponse)servletResponse;

        HttpSession session = req.getSession();

        if(session.getAttribute("loginInfo") != null) {
//            resp.sendRedirect("/login");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        Cookie cookie = findCookie(req.getCookies(),"remember-me");

        if(cookie == null) {
            resp.sendRedirect("/login-menu");
            return;
        }

        String uuid = cookie.getValue();
        try {
           MenuMemberDTO menuMemberDTO = MenuMemberService.INSTANCE.selectUUID(uuid);
           if(menuMemberDTO == null) {
               throw new Exception("쿠키 값에 해당하는 유저가 없음");
           }

           session.setAttribute("loginInfo", menuMemberDTO);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }//dofilter

    private Cookie findCookie(Cookie[] cookies, String cookieName) {
        if(cookies == null || cookies.length == 0) {
            return null;
        }

        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(cookieName)).findFirst();

        return result.isPresent() ? result.get() : null;

    } // findCookie 닫는 부분
}//class
