package com.busanit501.sampleserver.connectTest.service;

import com.busanit501.sampleserver.connectTest.todo.dto.TodoDTO;
import com.busanit501.sampleserver.connectTest.todo.srevice.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
@Log4j2
public class ServiceTest {
    private TodoService todoService;

    @BeforeEach
    public void ready() {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void register() throws Exception {
        TodoDTO todoDTO = TodoDTO.builder()
                        .title("샘플 11")
                        .dueDate(LocalDate.now())
                        .finished(false)
                        .build();

        log.info("todoDTO" +

                todoDTO);

        todoService.register2(todoDTO);
    }

}
