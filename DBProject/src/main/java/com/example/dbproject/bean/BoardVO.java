package com.example.dbproject.bean;

import java.util.Date;

public class BoardVO {
    private int seq;
    private String category;
    private String workname;
    private String workplace;
    private String deadline;
    private String note;
    private Date regdate;
    private int cnt;


    public int getSeq() {
        return seq;
    }
    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getWorkname() {
        return workname;
    }
    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public String getWorkplace() {
        return workplace;
    }
    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getDeadline() {
        return deadline;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Date getRegdate() {
        return regdate;
    }
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}