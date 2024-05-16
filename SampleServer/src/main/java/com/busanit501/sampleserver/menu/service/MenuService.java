package com.busanit501.sampleserver.menu.service;

import com.busanit501.sampleserver.menu.dto.MenuDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum MenuService {
    INSTANCE;
    public void register(MenuDTO dto){
        System.out.println("debug register dto 확인중 : " + dto);
    }

    public List<MenuDTO> getList() {
        List<MenuDTO> listSample = IntStream.range(0, 10).mapToObj(i -> {
            MenuDTO dto = new MenuDTO();
            dto.setMno((long)i);
            dto.setName("Sample Menu Title " + i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return listSample;
    };
}
