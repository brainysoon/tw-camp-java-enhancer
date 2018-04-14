package com.tw.util;

import org.junit.Assert;
import org.junit.Test;

public class StudentUtilsTest {

    @Test
    public void parserStudentInfoFrom() throws Exception {

        Assert.assertNotNull(StudentUtils.parserStudentInfoFrom("张三, 1, 数学:75, 语文:95, 英语:80, 编程:80"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void parserStudentInfoFailTest() throws Exception {

        StudentUtils.parserStudentInfoFrom("张三, 1, 数学,75, 语文:95, 英语:80, 编程:80");
    }
}
