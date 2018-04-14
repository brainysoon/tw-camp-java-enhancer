package com.tw.service.impl;

import com.tw.Constants;
import com.tw.bean.Report;
import com.tw.bean.StudentInfo;
import com.tw.service.ReportService;
import com.tw.util.StudentUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {

    private Map<String, StudentInfo> studentList;

    public ReportServiceImpl() {
        this.studentList = new HashMap<>(32);
    }

    @Override
    public Report generateReport(String noList) {

        List<String> noExist = parserStudentNoFrom(noList);
        if (noExist == null) return null;

        Report report = new Report();
        noExist.forEach(no -> {
            if (studentList.containsKey(no)) report.pickStudent(studentList.get(no));
        });

        return report;
    }

    @Override
    public StudentInfo addStudent(String studentInfoStr) {
        try {

            StudentInfo studentInfo = StudentUtils.parserStudentInfoFrom(studentInfoStr);
            this.studentList.put(studentInfo.getNo(), studentInfo);
            return studentInfo;
        } catch (Exception ex) {
            return null;
        }
    }

    private List<String> parserStudentNoFrom(String studentNoStr) {
        try {
            return Arrays.stream(studentNoStr.split(Constants.REGEX_COMMA))
                    .filter(no -> studentList.containsKey(no.trim()))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            return null;
        }
    }
}
