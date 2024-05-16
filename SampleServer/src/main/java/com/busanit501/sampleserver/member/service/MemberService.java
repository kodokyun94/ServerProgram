package com.busanit501.sampleserver.member.service;

import com.busanit501.sampleserver.member.dto.MemberDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum MemberService {
    INSTANCE;
    public void register(MemberDTO dto){
        System.out.println("debug register dto 확인중 : " + dto);
    }

    public List<MemberDTO> getList() {
        List<MemberDTO> listSample = IntStream.range(0, 10).mapToObj
                (i -> {
            MemberDTO dto = new MemberDTO();
            dto.setMemberNo((long)i);
            dto.setMemberTitle("Sample Menu Title " + i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return listSample;
    };
}
