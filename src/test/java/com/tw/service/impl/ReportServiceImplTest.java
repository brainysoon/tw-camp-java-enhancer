package com.tw.service.impl;

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

        String expectedResult = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.5|330\n" +
                "李四|85|80|70|90|81.25|325\n" +
                "========================\n" +
                "全班总分平均数：327.5\n" +
                "全班总分中位数：327.5";

        Assert.assertEquals(expectedResult, reportService.generateReport(noList));
    }

    @Test
    public void addStudentTest() {
        String noList = "34";
        reportService.addStudent("张五三, 34, 语文:95, 数学:75, 英语:80, 编程:80");

        Assert.assertTrue(reportService.generateReport(noList).contains("张五三"));

        noList = "37";
        reportService.addStudent("张五, 37, 语文:95 数学:75, 英语:80, 编程:80");

        Assert.assertFalse(reportService.generateReport(noList).contains("张五"));
    }
}
