package com.busanit501.sampleserver.connectTest.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter (urlPatterns = "/todo/*")
public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("로그인 필터 동작 여부 확인");

       HttpServletRequest req= (HttpServletRequest)servletRequest;
       HttpServletResponse resp= (HttpServletResponse)servletResponse;

        HttpSession session = req.getSession();

        if(session.getAttribute("loginInfo") == null) {
            resp.sendRedirect("/login");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }
}
