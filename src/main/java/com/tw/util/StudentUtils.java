package com.tw.util;

import com.tw.Constants;
import com.tw.bean.StudentInfo;

public class StudentUtils {

    public static StudentInfo parserStudentInfoFrom(String studentInfoStr) throws Exception {

        StudentInfo studentInfo = new StudentInfo();
        String[] stuInfos = studentInfoStr.split(Constants.REGEX_COMMA);

        studentInfo.setName(stuInfos[Constants.STUDENT_NAME_INDEX].trim());
        studentInfo.setNo(stuInfos[Constants.STUDENT_NO_INDEX].trim());

        for (int i = Constants.STUDENT_SUBJECT_INDEX_START; i < stuInfos.length; i++) {
            String gradeInfoStr = stuInfos[i].trim();
            String[] gradeInfo = gradeInfoStr.split(Constants.REGEX_COLON);
            studentInfo.getGradeList().put(gradeInfo[Constants.GRADE_SUBJECT_INDEX],
                    Double.parseDouble(gradeInfo[Constants.GRADE_INDEX]));
        }
        return studentInfo;
    }
}
