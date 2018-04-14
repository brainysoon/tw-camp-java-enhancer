package com.tw.bean;

import com.tw.GradeReporter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReportTest {

    @Test
    public void getTotalAverageTest() {
        GradeReporter mockGradeReporter1 = mock(GradeReporter.class);
        when(mockGradeReporter1.reportTotal()).thenReturn(1.2);

        GradeReporter mockGradeReporter2 = mock(GradeReporter.class);
        when(mockGradeReporter2.reportTotal()).thenReturn(1.3);

        Report report = new Report();
        report.setPickedStudent(Arrays.asList(mockGradeReporter1, mockGradeReporter2));

        Assert.assertEquals(1.25, report.getTotalAverage(), 0.001);
    }

    @Test
    public void getTotalMedian() {
        GradeReporter mockGradeReporter1 = mock(GradeReporter.class);
        when(mockGradeReporter1.reportTotal()).thenReturn(1.2);

        GradeReporter mockGradeReporter2 = mock(GradeReporter.class);
        when(mockGradeReporter2.reportTotal()).thenReturn(1.3);

        Report report = new Report();
        report.setPickedStudent(Arrays.asList(mockGradeReporter1, mockGradeReporter2));
        Assert.assertEquals(1.25, report.getTotalMedian(), 0.001);

        report.setPickedStudent(Arrays.asList(mockGradeReporter1));
        Assert.assertEquals(1.2, report.getTotalMedian(), 0.001);
    }
}
