package com.busanit501.sampleserver.connectTest.todo.srevice;

import com.busanit501.sampleserver.connectTest.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService_backup {
    INSTANCE;
    public void register(TodoDTO dto){
        System.out.println("debug register dto 확인중 : " + dto);
    }

    public List<TodoDTO> getList() {
        List<TodoDTO> listSample = IntStream.range(0, 10).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Sample Todo Title " + i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return listSample;
    };



}
