package com.busanit501.sampleserver.connectTest.todo.srevice;

import com.busanit501.sampleserver.connectTest.todo.dao.TodoDAO;
import com.busanit501.sampleserver.connectTest.todo.domain.TodoVO;
import com.busanit501.sampleserver.connectTest.todo.dto.TodoDTO;
import com.busanit501.sampleserver.connectTest.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO todoDAO;
    private ModelMapper modelMapper;

    TodoService() {
        todoDAO = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // 전체 조회
    public List<TodoDTO> listAll() throws Exception {
        // DB -> DAO -> TodoVO -> TodoDTO , 변환.
        // DB : 모델 : TodoVO
        // 화면 : 모델 : TodoDTO
        List<TodoVO> sampleList = todoDAO.selectAll();
        log.info("sampleList 확인1" + sampleList);
        List<TodoDTO> sampleDtoList = sampleList.stream()
                .map(vo -> modelMapper.map(vo,TodoDTO.class))
                .collect(Collectors.toList());
        return sampleDtoList;

    }

    //하나 조회
    public TodoDTO getSelectOne(Long tno) throws Exception {
        TodoVO sample = todoDAO.selectOne(tno);
        log.info("sampleList 확인1" + sample);
        TodoDTO todoDTO =  modelMapper.map(sample,TodoDTO.class);
        return todoDTO;
    }

    //수정
    public void updateTodo(TodoDTO todoDTO) throws Exception{
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoDAO.update(todoVO);
    }

    //쓰기
    public void register2(TodoDTO todoDTO) throws Exception{
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
//      System.out.println("todoVO"+todoVO);
        log.info("todoVO: " + todoVO);
        todoDAO.insert(todoVO);
    }

    //삭제
    public void deleteTodo(Long tno) throws Exception {
       todoDAO.delete(tno);
    }


    ///////////////////////////////////////////////////////
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
