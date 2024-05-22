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
import java.time.LocalDate;

@Log4j2
@WebServlet(name = "TodoUpdate", urlPatterns = "/todo/update")
public class TodoUpdateController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long tno = Long.valueOf(req.getParameter("tno"));
            TodoDTO sample = todoService.getSelectOne(tno);
            log.info("TodoListController 확인2 sample" + sample);
            req.setAttribute("sample",sample);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoUpd.jsp");
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long tno = Long.valueOf(req.getParameter("tno"));
        log.info("tno 확인 중 : " + tno);
        String title = req.getParameter("title");
        log.info("title 확인 중 2 : " + title);
        LocalDate localDate =LocalDate.parse(req.getParameter("dueDate")) ;
        log.info("localDate 확인 중 3 : " + localDate);
        String checkBox = req.getParameter("finished");
        log.info("checkBox 확인 중 4 : " + checkBox);



        TodoDTO todoDTO = TodoDTO.builder()
                .title(title)
                .dueDate(localDate)
                .finished(checkBox != null && checkBox.equals("on") ? true:false)
                .tno(tno)
                .build();

        try {
            todoService.updateTodo(todoDTO);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
