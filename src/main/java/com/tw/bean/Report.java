package com.tw.bean;

import com.tw.GradeReporter;
import com.tw.util.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class Report {

    private List<GradeReporter> pickedStudent;

    public Report() {
        this.pickedStudent = new ArrayList<>();
    }


    public List<GradeReporter> getPickedStudent() {
        return pickedStudent;
    }

    public void setPickedStudent(List<GradeReporter> pickedStudent) {
        this.pickedStudent = pickedStudent;
    }

    public void pickStudent(GradeReporter gradeReporter) {
        this.pickedStudent.add(gradeReporter);
    }

    public Double getTotalAverage() {
        return pickedStudent
                .stream()
                .mapToDouble(GradeReporter::reportTotal)
                .reduce(0.0D, (acc, stuTotal) -> acc + stuTotal / pickedStudent.size());
    }

    public Double getTotalMedian() {
        double[] sortedList = pickedStudent
                .stream()
                .mapToDouble(GradeReporter::reportTotal)
                .sorted()
                .toArray();

        if (sortedList.length == 0) {
            return 0.0D;
        } else if (sortedList.length % 2 == 0) {
            return (sortedList[sortedList.length / 2] + sortedList[sortedList.length / 2 - 1]) / 2;
        } else {
            return sortedList[sortedList.length / 2];
        }
    }
}
