package com.tw.bean;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StudentInfoTest {

    @Test
    public void reportGradeTest() {

        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setName("Xi");
        studentInfo.setNo("12");
        Map<String, Double> grades = new HashMap<>();
        grades.put("语文", 12.40);
        grades.put("数学", 234.23);
        grades.put("英语", 321.0);
        grades.put("编程", 234D);
        studentInfo.setGradeList(grades);

        Assert.assertEquals("Xi|234.23|12.4|321|234|200.4075", studentInfo.reportGrade());
    }

    @Test
    public void reportTotalTest() {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setName("Xi");
        studentInfo.setNo("12");
        Map<String, Double> grades = new HashMap<>();
        grades.put("语文", 12.40);
        grades.put("数学", 234.23);
        grades.put("英语", 321.0);
        grades.put("编程", 234D);
        studentInfo.setGradeList(grades);

        Assert.assertEquals(200.4075, studentInfo.reportTotal(), 0.001);
    }
}
