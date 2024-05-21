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

    public void register(MenuDTO dto){
        System.out.println("debug register dto 확인중 : " + dto);
    }

    public List<MenuDTO> getList() throws Exception {
        List<MenuVO> sampleList = menuDAO.selectAll();
        log.info("sampleList 확인1" + sampleList);
        List<MenuDTO> sampleDtoList = sampleList.stream()
                .map(vo -> modelMapper.map(vo,MenuDTO.class))
                .collect(Collectors.toList());
        return sampleDtoList;
    };


}
