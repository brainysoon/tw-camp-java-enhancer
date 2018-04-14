package com.tw.service.impl;

import com.tw.bean.StudentInfo;
import com.tw.service.ReportService;

import java.util.HashMap;
import java.util.Map;

public class ReportServiceImpl implements ReportService {

    private Map<String, StudentInfo> studentList;

    public ReportServiceImpl() {
        this.studentList = new HashMap<>(32);
    }

    @Override
    public String generateReport(String noList) {
        return null;
    }

    @Override
    public boolean addStudent(String studentInfo) {
        return false;
    }
}
