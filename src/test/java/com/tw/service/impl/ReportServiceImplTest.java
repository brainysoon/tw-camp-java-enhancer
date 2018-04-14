package com.tw.service.impl;

import com.tw.bean.Report;
import com.tw.bean.StudentInfo;
import com.tw.service.ReportService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReportServiceImplTest {

    private ReportService reportService;

    private void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    @Before
    public void setUp() throws Exception {
        setReportService(new ReportServiceImpl());
    }

    @Test
    public void generateReportTest() {

        String noList = "1, 2";
        reportService.addStudent("张三, 1, 数学:75, 语文:95, 英语:80, 编程:80");
        reportService.addStudent("李四, 2, 数学:85, 语文:80, 英语:70, 编程:90");

        Report report = reportService.generateReport(noList);

        Assert.assertEquals(2, report.getPickedStudent().size());
        Assert.assertEquals(327.5D, report.getTotalAverage(), 0.001);
        Assert.assertEquals(327.5D, report.getTotalMedian(), 0.001);
    }

    @Test
    public void addStudentTest() {

        StudentInfo studentInfo = reportService.addStudent("张五三, 34, 语文:95, 数学:75, 英语:80, 编程:80");
        Assert.assertNotNull(studentInfo);

        studentInfo = reportService.addStudent("张五, 37, 语文:95 数学:75, 英语:80, 编程:80");
        Assert.assertNull(studentInfo);
    }
}
