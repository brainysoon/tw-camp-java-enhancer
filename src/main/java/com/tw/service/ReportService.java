package com.tw.service;

import com.tw.bean.Report;
import com.tw.bean.StudentInfo;

public interface ReportService {

    Report generateReport(String noList);

    StudentInfo addStudent(String studentInfo);
}