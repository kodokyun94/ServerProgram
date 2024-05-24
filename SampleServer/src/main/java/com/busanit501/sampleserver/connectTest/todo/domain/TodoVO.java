package com.busanit501.sampleserver.connectTest.todo.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
//@Setter
@Builder
//@ToString
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}