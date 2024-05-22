package com.busanit501.sampleserver.connectTest.todo.controller;

import com.busanit501.sampleserver.connectTest.todo.dto.MemberDTO;
import com.busanit501.sampleserver.connectTest.todo.dto.TodoDTO;
import com.busanit501.sampleserver.connectTest.todo.srevice.TodoService;
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
@WebServlet(name = "todoList",urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    //주입 , 서비스 인스턴스 , 포함.
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // DB 에서 , 전체 목록을 가져오기.

//        HttpSession session = req.getSession();
//        String loginInfoSession = (String) session.getAttribute("loginInfo");
//        log.info("정보 겟 : "+loginInfoSession);
        HttpSession session = req.getSession();
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginInfo");
        log.info("Login info 세션의 정보 get하기.: " + memberDTO);

        try {
            List<TodoDTO> sampleList = null;
            sampleList = todoService.INSTANCE.listAll();
//            log.info("TodoListController 확인2" + sampleList);
            req.setAttribute("list",sampleList);
            req.setAttribute("memberDTO",memberDTO);
            req.getRequestDispatcher("/WEB-INF/todo/todoList.jsp")
                    .forward(req, resp);
        } catch (Exception e) {


            throw new RuntimeException(e);
        }


    }
}
