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
        MemberVO memberVO = memberDAO.getWithpasswordMember("lsy", "1234");
//        System.out.println("memberVO : " + memberVO);
        log.info("memberVO : " + memberVO);
    }

    @Test
    public void updateUUID() throws Exception {
       memberDAO.updateUUID("lsy", "testuuid22222222");
//        System.out.println("memberVO : " + memberVO);
//        log.info("memberVO : " + memberVO);
    }
}
