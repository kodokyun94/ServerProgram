package com.busanit501.sampleserver.connectTest.MemberDAOTest;

import com.busanit501.sampleserver.connectTest.menu.dao.MenuMemberDAO;
import com.busanit501.sampleserver.connectTest.menu.domain.MenuMemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Log4j2
public class MenuMemberServiceTest {


    private MenuMemberDAO MenumemberDAO;

    @BeforeEach
    public void ready() {
        MenumemberDAO = new MenuMemberDAO();
    }

    @Test
    public void getSelectOne() throws Exception {
        MenuMemberVO memberVO = MenumemberDAO.getWithpasswordMember("lsy", "1234");
//        System.out.println("memberVO : " + memberVO);
        log.info("memberVO : " + memberVO);
    }

    @Test
    public void updateUUID() throws Exception {
        MenumemberDAO.updateUUID("lsy", "testuuid22222222");
//        System.out.println("memberVO : " + memberVO);
//        log.info("memberVO : " + memberVO);
    }

    @Test
    public void selectUUID() throws Exception {
        MenuMemberVO memberVO = MenumemberDAO.selectUUID("c052427d-9bff-4eea-91e9-83dc9f2244ff");
        log.info("memberVO : " + memberVO);
    }

    @Test
    public void insertMember() throws Exception {
        MenuMemberVO memberVO = MenuMemberVO.builder()
                .mid("lsy0523")
                .mpw("1234")
                .mname("이상용0523")
                .build();
        MenumemberDAO.insertMember(memberVO);
        log.info("memberVO : " + memberVO);
    }
}
