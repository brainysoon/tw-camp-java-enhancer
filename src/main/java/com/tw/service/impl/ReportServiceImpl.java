package com.tw.service.impl;

import com.tw.bean.StudentInfo;
import com.tw.service.ReportService;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {

    private Map<String, StudentInfo> studentList;
    private List<String> gradeSubjectList = Arrays.asList("数学", "语文", "英语", "编程");

    public ReportServiceImpl() {
        this.studentList = new HashMap<>(32);
    }

    @Override
    public String generateReport(String noList) {
        StringBuffer sb = new StringBuffer("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n");

        List<String> noExist = null;
        try {
            noExist = parserStudentNoFrom(noList);
        } catch (Exception ex) {
            return null;
        }

        double[] classSumGrade = noExist.stream()
                .mapToDouble((no) -> {
                    StudentInfo stu = studentList.get(no.trim());
                    sb.append(stu.getName());
                    sb.append("|");

                    gradeSubjectList.forEach(subject -> {
                        Double grade = stu.getGradeList().get(subject);
                        if (grade == null) return;
                        sb.append(removeTrailZeros(grade.toString()));
                        sb.append("|");
                    });

                    Double sumGrade = stu.getGradeList().values().stream()
                            .reduce(0.0D, (acc, gradle) -> acc + gradle);
                    sb.append(sumGrade / 4);
                    sb.append("|");
                    sb.append(removeTrailZeros(sumGrade.toString()));
                    sb.append("\n");
                    return sumGrade;
                }).toArray();
        sb.append("========================\n");

        Double averageSum = Arrays.stream(classSumGrade)
                .reduce(0.0D, (acc, grade) -> acc + grade / classSumGrade.length);

        double[] sortedAverageSum = Arrays.stream(classSumGrade)
                .sorted()
                .toArray();

        Double meddleNumber = 0.0D;
        if (sortedAverageSum.length > 0) {
            if (sortedAverageSum.length % 2 == 0) {
                meddleNumber = (sortedAverageSum[sortedAverageSum.length / 2] + sortedAverageSum[sortedAverageSum.length / 2 - 1]) / 2;
            } else {
                meddleNumber = sortedAverageSum[sortedAverageSum.length / 2];
            }
        }

        sb.append("全班总分平均数：");
        sb.append(averageSum.doubleValue());
        sb.append("\n");
        sb.append("全班总分中位数：");
        sb.append(meddleNumber.doubleValue());

        return sb.toString();
    }

    @Override
    public StudentInfo addStudent(String studentInfoStr) {
        try {

            StudentInfo studentInfo = parserStudentInfoFrom(studentInfoStr);
            this.studentList.put(studentInfo.getNo(), studentInfo);
            return studentInfo;
        } catch (Exception ex) {
            return null;
        }
    }

    private StudentInfo parserStudentInfoFrom(String studentInfoStr) throws Exception {
        StudentInfo studentInfo = new StudentInfo();

        String[] stuInfos = studentInfoStr.split(",");
        studentInfo.setName(stuInfos[0].trim());
        studentInfo.setNo(stuInfos[1].trim());
        for (int i = 2; i < stuInfos.length; i++) {
            String gradeInfoStr = stuInfos[i].trim();
            String[] gradeInfo = gradeInfoStr.split(":");
            studentInfo.getGradeList().put(gradeInfo[0], Double.parseDouble(gradeInfo[1]));
        }
        return studentInfo;
    }

    private String removeTrailZeros(String doubleValue) {
        int lastZeros = -1;
        for (int i = doubleValue.length() - 1; i >= 0; i--) {
            if (doubleValue.charAt(i) == '0') lastZeros = i;
            else break;
        }

        if (lastZeros > 0) {
            return doubleValue.substring(0, lastZeros - 1);
        }
        return doubleValue;
    }

    private List<String> parserStudentNoFrom(String studentNoStr) throws Exception {
        return Arrays.stream(studentNoStr.split(","))
                .filter(no -> studentList.containsKey(no.trim()))
                .collect(Collectors.toList());
    }
}
