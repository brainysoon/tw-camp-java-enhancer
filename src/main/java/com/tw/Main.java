package com.tw;

import com.tw.bean.StudentInfo;
import com.tw.service.ReportService;
import com.tw.service.impl.ReportServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ReportService reportService = new ReportServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. 添加学生\n" +
                    "2. 生成成绩单\n" +
                    "3. 退出\n" +
                    "请输入你的选择（1～3）：");

            if (scanner.hasNext()) {
                int menuItem = Integer.parseInt(scanner.nextLine());
                if (menuItem == 1) {
                    System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                    while (scanner.hasNext()) {
                        String studentInfoStr = scanner.nextLine();
                        StudentInfo studentInfo = reportService.addStudent(studentInfoStr);
                        if (studentInfo != null) {
                            System.out.println("学生" + studentInfo.getName() + "的成绩被添加");
                            break;
                        } else {
                            System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
                        }
                    }

                } else if (menuItem == 2) {
                    System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                    while (scanner.hasNext()) {
                        String noList = scanner.nextLine();
                        String report = reportService.generateReport(noList);

                        if (report != null) {
                            System.out.println(report);
                            System.out.println("\n");
                            break;
                        } else {
                            System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                        }
                    }
                } else {
                    break;
                }
            }
        }
    }
}
