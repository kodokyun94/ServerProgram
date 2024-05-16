package com.busanit501.sampleserver.connectTest.member.dto;

import java.time.LocalDate;

public class MemberDTO {
    private long memberNo;
    private String memberTitle;
    private LocalDate dueDate;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberNo=" + memberNo +
                ", memberTitle='" + memberTitle + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }

    public long getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(long memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberTitle() {
        return memberTitle;
    }

    public void setMemberTitle(String memberTitle) {
        this.memberTitle = memberTitle;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
