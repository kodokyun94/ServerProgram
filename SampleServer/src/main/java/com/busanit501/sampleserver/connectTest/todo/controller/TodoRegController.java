package com.busanit501.sampleserver.connectTest.todo.controller;

import com.busanit501.sampleserver.connectTest.todo.dto.TodoDTO;
import com.busanit501.sampleserver.connectTest.todo.srevice.TodoService;
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
@WebServlet(name="todoReg", urlPatterns = "/todo/register")
public class TodoRegController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //조회
        if(session.isNew()){
            log.info("new JsessionID : 새로운 유저" );
            resp.sendRedirect("/login");
            return;
        }

        if(session.getAttribute("loginInfo") == null){
            log.info("로그인 정보가 없는 유저 ");
            resp.sendRedirect("/login");
            return;
        }

        //todo 글 입력 폼
        //화면 입력 폼
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoReg.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //로직처리

        TodoDTO todoDTO = TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate")))
                .build();

        //등록
        try {
            todoService.register2(todoDTO);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}



