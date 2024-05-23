package com.busanit501.sampleserver.connectTest.menu.service;

import com.busanit501.sampleserver.connectTest.menu.dao.MenuMemberDAO;
import com.busanit501.sampleserver.connectTest.menu.domain.MenuMemberVO;
import com.busanit501.sampleserver.connectTest.menu.dto.MenuMemberDTO;
import com.busanit501.sampleserver.connectTest.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MenuMemberService {
    INSTANCE;

    private MenuMemberDAO menuMemberDAO;
    private ModelMapper modelMapper;


    MenuMemberService() {
        menuMemberDAO = new MenuMemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //하나 조회
    public MenuMemberDTO getSelectOneMember(String mid, String mpw) throws Exception {
        MenuMemberVO sample = menuMemberDAO.getWithpasswordMember(mid, mpw);
//        log.info("sampleList 확인1" + sample);
        MenuMemberDTO menuMemberDTO =  modelMapper.map(sample, MenuMemberDTO.class);
        return menuMemberDTO;
    }

    public void updateUUID(String mid,String uuid) throws Exception {
        menuMemberDAO.updateUUID(mid, uuid);
    }

    //
    public void insertMember(MenuMemberDTO memberDTO) throws Exception {
        MenuMemberVO menumemberVO = modelMapper.map(memberDTO, MenuMemberVO.class);
        menuMemberDAO.insertMember(menumemberVO);
    }

    public MenuMemberDTO selectUUID(String uuid) throws Exception {
      MenuMemberVO menumemberVO = menuMemberDAO.selectUUID(uuid);
      MenuMemberDTO menuMemberDTO =  modelMapper.map(menumemberVO, MenuMemberDTO.class);
      return menuMemberDTO;
    }

    // 자동로그인 체크 여부
    public void checkAutoLogin(String mid, boolean autoLogined) throws Exception {
        menuMemberDAO.checkAutoLogin(mid, autoLogined);
    }

}
