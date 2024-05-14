package com.busanit501.sampleserver.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class KoreanCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    //한글이 안깨지는 필터
    HttpServletRequest req =(HttpServletRequest)servletRequest;
    req.setCharacterEncoding("UTF-8");

    filterChain.doFilter(servletRequest, servletResponse);
    }
}
