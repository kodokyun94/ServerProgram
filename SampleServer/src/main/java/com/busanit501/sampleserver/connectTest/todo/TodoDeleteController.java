package com.busanit501.sampleserver.connectTest.todo;

import com.busanit501.sampleserver.connectTest.HelloServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="tododelete", urlPatterns = "/todo/delete")
public class TodoDeleteController extends HelloServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/todo/todoDelete.jsp");
        requestDispatcher.forward(req, resp);
    }
}
