package com.busanit501.sampleserver.connectTest.todo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
