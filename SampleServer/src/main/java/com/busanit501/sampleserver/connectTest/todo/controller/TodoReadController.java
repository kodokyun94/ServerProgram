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
import java.io.IOException;
@Log4j2
@WebServlet(name = "todoRead", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long tno = Long.valueOf(req.getParameter("tno"));
            TodoDTO sample = todoService.getSelectOne(tno);
            log.info("TodoListController 확인2 sample" + sample);
            req.setAttribute("sample",sample);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoRead.jsp");
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }

    }

}
