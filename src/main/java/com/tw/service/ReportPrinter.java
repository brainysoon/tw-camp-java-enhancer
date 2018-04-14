package com.tw.service;

import com.tw.bean.Report;

public interface ReportPrinter {
    String REPORT_TITLE = "成绩单";
    String REPORT_SUBJECT_BAR = "姓名|数学|语文|英语|编程|平均分|总分";
    String CLASS_TOTAL_AVERAGE_PRE_FIX = "全班总分平均数：";
    String CLASS_TOTAL_MEDIAN_PRE_FIX = "全班总分中位数：";
    String SPLIT_LINE = "========================";

    void printReport(Report report);
}
