package com.tw.bean;

import com.tw.Constants;
import com.tw.GradeReporter;
import com.tw.util.NumberUtils;

import java.util.HashMap;
import java.util.Map;

public class StudentInfo implements GradeReporter {

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

    @Override
    public String reportGrade() {

        StringBuffer sb = new StringBuffer();
        sb.append(this.getName());
        sb.append(Constants.SPLIT_INLINE);

        Constants.SUBJECT_ORDER_LIST
                .forEach(subject -> {
                    sb.append(NumberUtils.removeTrailZeros(gradeList.get(subject)));
                    sb.append(Constants.SPLIT_INLINE);
                });

        sb.append(reportTotal());

        return sb.toString();
    }

    @Override
    public Double reportTotal() {
        return this.gradeList.values().stream()
                .reduce(0.0D, (acc, value) -> acc + value / gradeList.size());
    }
}
