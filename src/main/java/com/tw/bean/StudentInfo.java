package com.tw.bean;

import java.util.HashMap;
import java.util.Map;

public class StudentInfo {

    private String name;
    private String no;
    private Map<String, Double> gradeList;

    public StudentInfo() {
        this.gradeList = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Map<String, Double> getGradeList() {
        return gradeList;
    }

    public void setGradeList(Map<String, Double> gradeList) {
        this.gradeList = gradeList;
    }
}
