package com.busanit501.sampleserver.todo;

import com.busanit501.sampleserver.todo.dto.TodoDTO;
import com.busanit501.sampleserver.todo.srevice.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoList", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<TodoDTO> sampleList = TodoService.INSTANCE.getList();
       req.setAttribute("list", sampleList);
       RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoList.jsp");
       requestDispatcher.forward(req, resp);
    }
}
