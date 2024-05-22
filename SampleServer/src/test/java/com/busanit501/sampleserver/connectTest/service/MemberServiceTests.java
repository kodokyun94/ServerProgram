package com.busanit501.sampleserver.connectTest.service;

import com.busanit501.sampleserver.connectTest.todo.dto.MemberDTO;
import com.busanit501.sampleserver.connectTest.todo.srevice.MemberService;
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
      MemberDTO memberDTO = memberService.getSelectOneMember("lsy", "1234");
      log.info("memberDTO: ", memberDTO);
    }

    @Test
    public void updateUUID() throws Exception {
        memberService.updateUUID("lsy", "testuuid333333333333333333333333");
    }

}
