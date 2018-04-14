package com.tw;

import java.util.Arrays;
import java.util.List;

public interface Constants {
    String SPLIT_INLINE = "|";
    String REGEX_COMMA = ",";
    List<String> SUBJECT_ORDER_LIST = Arrays.asList("数学", "语文", "英语", "编程");
    String REGEX_COLON = ":";
    int STUDENT_NAME_INDEX = 0;
    int STUDENT_NO_INDEX = 1;
    int STUDENT_SUBJECT_INDEX_START = 2;
    int GRADE_SUBJECT_INDEX = 0;
    int GRADE_INDEX = 1;
    String MAIN_MENU = "1. 添加学生\n" +
            "2. 生成成绩单\n" +
            "3. 退出\n" +
            "请输入你的选择（1～3）：";
    String STUDENT_INFO_INPUT_HINT = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    String STUDENT_PRE_FIX = "学生";
    String STUDENT_GRADE_SUB_FIX = "的成绩被添加";
    String STUDENT_INFO_INPUT_ERROR_HINT = "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：";
    String PRINT_REPORTER_HINE = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
    String REPORTER_NO_ERROR_HINT = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：";
}
