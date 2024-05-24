package com.busanit501.sampleserver.connectTest.member;

import com.busanit501.sampleserver.connectTest.member.dto.MemberDTO;
import com.busanit501.sampleserver.connectTest.member.service.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MemberController", urlPatterns = "/member/list")
public class MemberController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        List<MemberDTO> sampleList = MemberService.INSTANCE.getList();
        req.setAttribute("list",sampleList);

        // 기본, 뷰 jsp 파일로 전달하기.
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/member/memberList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
