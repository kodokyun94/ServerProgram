package com.busanit501.sampleserver.connectTest.menu.service;

import com.busanit501.sampleserver.connectTest.menu.dao.MenuDAO;
import com.busanit501.sampleserver.connectTest.menu.domain.MenuVO;
import com.busanit501.sampleserver.connectTest.menu.dto.MenuDTO;
import com.busanit501.sampleserver.connectTest.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;
@Log4j2
public enum MenuService {
    INSTANCE;
    private MenuDAO menuDAO;
    private ModelMapper modelMapper;

    MenuService() {
        menuDAO = new MenuDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }
    // 전체 조회
    public List<MenuDTO> listAll() throws Exception {
        // DB -> DAO -> TodoVO -> TodoDTO , 변환.
        // DB : 모델 : TodoVO
        // 화면 : 모델 : TodoDTO
        List<MenuVO> sampleList = menuDAO.selectAll();
        List<MenuDTO> sampleDtoList = sampleList.stream()
                .map(vo -> modelMapper.map(vo,MenuDTO.class))
                .collect(Collectors.toList());
        return sampleDtoList;
    }

    //하나 조회
    public MenuDTO getSelectOne(Long tno) throws Exception {
        MenuVO sample = menuDAO.selectOne(tno);
        log.info("sampleList 확인1" + sample);
        MenuDTO menuDTO =  modelMapper.map(sample,MenuDTO.class);
        return menuDTO;
    }

    //수정
    public void updateMenu(MenuDTO menuDTO) throws Exception{
        MenuVO menuVO = modelMapper.map(menuDTO, MenuVO.class);
        menuDAO.update(menuVO);
    }

    //쓰기
    public void register(MenuDTO menuDTO) throws Exception{
        MenuVO menuVO = modelMapper.map(menuDTO, MenuVO.class);
        log.info("menuVO: " + menuVO);
        menuDAO.insert(menuVO);
    }

    //삭제
    public void deleteMenu(Long tno) throws Exception {
        menuDAO.delete(tno);
    }









    ///////////////////////////////////////
//    public void register(MenuDTO dto){
//        System.out.println("debug register dto 확인중 : " + dto);
//    }
//
//    public List<MenuDTO> getList() throws Exception {
//        List<MenuVO> sampleList = menuDAO.selectAll();
//        log.info("sampleList 확인1" + sampleList);
//        List<MenuDTO> sampleDtoList = sampleList.stream()
//                .map(vo -> modelMapper.map(vo,MenuDTO.class))
//                .collect(Collectors.toList());
//        return sampleDtoList;
//    };


}
