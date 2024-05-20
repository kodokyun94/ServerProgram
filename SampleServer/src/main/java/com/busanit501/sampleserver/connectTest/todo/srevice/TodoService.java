package com.busanit501.sampleserver.connectTest.todo.srevice;

import com.busanit501.sampleserver.connectTest.todo.dao.TodoDAO;
import com.busanit501.sampleserver.connectTest.todo.domain.TodoVO;
import com.busanit501.sampleserver.connectTest.todo.dto.TodoDTO;
import com.busanit501.sampleserver.connectTest.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;

    private TodoDAO todoDAO;
    private ModelMapper modelMapper;

    TodoService() {
        todoDAO = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    //전체조회

    //하나 조회

    //수정

    //쓰기
    public void register2(TodoDTO todoDTO) throws Exception{
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        System.out.println("todoVO"+todoVO);
        todoDAO.insert(todoVO);
    }

    //삭제

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
