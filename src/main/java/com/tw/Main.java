package com.tw;

import com.tw.bean.Report;
import com.tw.bean.StudentInfo;
import com.tw.service.ReportPrinter;
import com.tw.service.ReportService;
import com.tw.service.impl.ReportPrinterImpl;
import com.tw.service.impl.ReportServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ReportService reportService = new ReportServiceImpl();
        ReportPrinter reportPrinter = new ReportPrinterImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(Constants.MAIN_MENU);

            if (scanner.hasNext()) {
                int menuItem = Integer.parseInt(scanner.nextLine());
                if (menuItem == 1) {
                    System.out.println(Constants.STUDENT_INFO_INPUT_HINT);
                    while (scanner.hasNext()) {
                        String studentInfoStr = scanner.nextLine();
                        StudentInfo studentInfo = reportService.addStudent(studentInfoStr);
                        if (studentInfo != null) {
                            System.out.print(Constants.STUDENT_PRE_FIX);
                            System.out.print(studentInfo.getName());
                            System.out.println(Constants.STUDENT_GRADE_SUB_FIX);
                            break;
                        } else {
                            System.out.println(Constants.STUDENT_INFO_INPUT_ERROR_HINT);
                        }
                    }

                } else if (menuItem == 2) {
                    System.out.println(Constants.PRINT_REPORTER_HINE);
                    while (scanner.hasNext()) {
                        String noList = scanner.nextLine();
                        Report report = reportService.generateReport(noList);

                        if (report != null) {
                            reportPrinter.printReport(report);
                            break;
                        } else {
                            System.out.println(Constants.REPORTER_NO_ERROR_HINT);
                        }
                    }
                } else {
                    break;
                }
            }
        }
    }
}
