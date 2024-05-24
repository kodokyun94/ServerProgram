package com.busanit501.sampleserver.connectTest.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
    private long menuNo;
    private String menuTitle;
    private LocalDate menuRegDate;
}


