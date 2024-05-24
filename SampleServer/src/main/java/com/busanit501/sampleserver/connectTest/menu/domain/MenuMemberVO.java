package com.busanit501.sampleserver.connectTest.menu.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Builder
public class MenuMemberVO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
