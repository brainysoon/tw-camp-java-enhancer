package com.tw.service;

import com.tw.bean.StudentInfo;

public interface ReportService {

    String generateReport(String noList);

    StudentInfo addStudent(String studentInfo);
}