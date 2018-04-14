package com.tw.service.impl;

import com.tw.GradeReporter;
import com.tw.bean.Report;
import com.tw.service.ReportPrinter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReporterPrinterImplTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ReportPrinter reportPrinter = new ReportPrinterImpl();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void printReportTest() {

        GradeReporter mockGradeReporter1 = mock(GradeReporter.class);
        when(mockGradeReporter1.reportGrade()).thenReturn("张三|75|95|80|80|82.5|330");

        GradeReporter mockGradeReporter2 = mock(GradeReporter.class);
        when(mockGradeReporter2.reportGrade()).thenReturn("李四|85|80|70|90|81.25|325");

        Report mockReport = mock(Report.class);
        when(mockReport.getPickedStudent()).thenReturn(Arrays.asList(mockGradeReporter1, mockGradeReporter2));
        when(mockReport.getTotalAverage()).thenReturn(327.5);
        when(mockReport.getTotalMedian()).thenReturn(327.5);

        reportPrinter.printReport(mockReport);

        String expectedResult = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.5|330\n" +
                "李四|85|80|70|90|81.25|325\n" +
                "========================\n" +
                "全班总分平均数：327.5\n" +
                "全班总分中位数：327.5\n";

        Assert.assertEquals(expectedResult, outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }
}
