package com.busanit501.sampleserver.connectTest.todo.domain;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Builder
public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
