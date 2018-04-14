package com.tw.service.impl;

import com.tw.bean.Report;
import com.tw.service.ReportPrinter;
import com.tw.util.NumberUtils;

public class ReportPrinterImpl implements ReportPrinter {

    @Override
    public void printReport(Report report) {

        System.out.println(REPORT_TITLE);
        System.out.println(REPORT_SUBJECT_BAR);
        System.out.println(SPLIT_LINE);

        report.getPickedStudent().forEach(gradeReporter
                -> System.out.println(gradeReporter.reportGrade()));
        System.out.println(SPLIT_LINE);

        System.out.print(CLASS_TOTAL_AVERAGE_PRE_FIX);
        System.out.println(NumberUtils.removeTrailZeros(report.getTotalAverage()));
        System.out.print(CLASS_TOTAL_MEDIAN_PRE_FIX);
        System.out.println(NumberUtils.removeTrailZeros(report.getTotalMedian()));
    }
}
