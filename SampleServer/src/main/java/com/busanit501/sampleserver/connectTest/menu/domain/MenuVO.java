package com.busanit501.sampleserver.connectTest.menu.domain;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class MenuVO {
        private Long menuNo;
        private String menuTitle ;
        private LocalDate menuRegDate;
    }

