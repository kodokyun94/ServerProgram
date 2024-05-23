package com.busanit501.sampleserver.connectTest.service;

import com.busanit501.sampleserver.connectTest.todo.dto.MemberDTO;
import com.busanit501.sampleserver.connectTest.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
@Log4j2
public class MemberServiceTests {
    private MemberService memberService;

    @BeforeEach
    public void ready() {
        memberService = MemberService.INSTANCE;
    }

    @Test
    public void register() throws Exception {
      MemberDTO memberDTO = memberService.getOneMember("lsy", "1234");
      log.info("memberDTO: ", memberDTO);
    }

    @Test
    public void updateUUID() throws Exception {
        memberService.updateUUID("lsy", "testuuid333333333333333333333333");
    }

    @Test
    public void selectUUID() throws Exception {
        MemberDTO memberDTO =  memberService.selectUUID("c052427d-9bff-4eea-91e9-83dc9f2244ff");
        log.info("memberDTO : "+memberDTO);
    }

    @Test
    public void insertMember() throws Exception {
      MemberDTO memberDTO = MemberDTO.builder()
              .mid("lsy05232")
              .mpw("1234")
              .mname("이상용05232")
              .build();
       memberService.insertMember(memberDTO);
       log.info("memberDTO : "+memberDTO);
    }

}
