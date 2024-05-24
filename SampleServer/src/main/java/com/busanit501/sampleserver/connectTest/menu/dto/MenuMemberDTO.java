package com.busanit501.sampleserver.connectTest.menu.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class MenuMemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
