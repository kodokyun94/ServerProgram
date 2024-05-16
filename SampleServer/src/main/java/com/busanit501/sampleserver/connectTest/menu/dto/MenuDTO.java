package com.busanit501.sampleserver.connectTest.menu.dto;

import java.time.LocalDate;

public class MenuDTO {
    private long mno;
    private String name;
    private LocalDate dueDate;

    @Override
    public String toString() {
        return "MenuDTO{" +
                "mno=" + mno +
                ", name='" + name + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }

    public long getMno() {
        return mno;
    }

    public void setMno(long mno) {
        this.mno = mno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
