package com.busanit501.sampleserver.connectTest.todo.srevice;

import com.busanit501.sampleserver.connectTest.todo.dao.MemberDAO;
import com.busanit501.sampleserver.connectTest.todo.domain.MemberVO;
import com.busanit501.sampleserver.connectTest.todo.dto.MemberDTO;
import com.busanit501.sampleserver.connectTest.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;


    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //하나 조회
    public MemberDTO getSelectOneMember(String mid,String mpw) throws Exception {
        MemberVO sample = memberDAO.getWithpasswordMember(mid, mpw);
//        log.info("sampleList 확인1" + sample);
        MemberDTO memberDTO =  modelMapper.map(sample, MemberDTO.class);
        return memberDTO;
    }

    public void updateUUID(String mid,String uuid) throws Exception {
        memberDAO.updateUUID(mid, uuid);
    }

}
