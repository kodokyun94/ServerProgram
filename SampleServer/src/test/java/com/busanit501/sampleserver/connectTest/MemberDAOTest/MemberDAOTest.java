package com.busanit501.sampleserver.connectTest.MemberDAOTest;

import com.busanit501.sampleserver.connectTest.todo.dao.MemberDAO;
import com.busanit501.sampleserver.connectTest.todo.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



@Log4j2
public class MemberDAOTest {

    private MemberDAO memberDAO;

    @BeforeEach
    public void ready() {
        memberDAO = new MemberDAO();
    }

    @Test
    public void getSelectOne() throws Exception {
        MemberVO memberVO = memberDAO.getWithPasswordMember("lsy", "1234");
//        System.out.println("memberVO : " + memberVO);
        log.info("memberVO : " + memberVO);
    }

    @Test
    public void updateUUID() throws Exception {
       memberDAO.updateUUID("lsy", "testuuid22222222");
//        System.out.println("memberVO : " + memberVO);
//        log.info("memberVO : " + memberVO);
    }

    @Test
    public void selectUUID() throws Exception {
       MemberVO memberVO = memberDAO.selectUUID("c052427d-9bff-4eea-91e9-83dc9f2244ff");
       log.info("memberVO : " + memberVO);
    }

    @Test
    public void insertMember() throws Exception {
        MemberVO memberVO = MemberVO.builder()
                .mid("lsy0523")
                .mpw("1234")
                .mname("이상용0523")
                .build();
        memberDAO.insertMember(memberVO);
        log.info("memberVO : " + memberVO);
    }
}
