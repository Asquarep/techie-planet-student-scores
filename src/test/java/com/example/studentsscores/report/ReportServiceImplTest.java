package com.example.studentsscores.report;

import com.example.studentsscores.student.Student;
import com.example.studentsscores.student.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ReportServiceImplTest {
    @InjectMocks
    private ReportServiceImpl reportService;
    @Mock
    private ReportRepository reportRepository;
    @Mock
    private StudentRepository studentRepository;

    private Report report1;
    private Report report2;
    private Report report3;
    private Student student1;
    private Student student2;
    private Student student3;
    private ReportResponse reportResponse1;
    private ReportResponse reportResponse2;
    private ReportResponse reportResponse3;
    private ReportRequest reportRequest1;
    private ReportRequest reportRequest2;
    private ReportRequest reportRequest3;





    @BeforeEach
    void setUp() {
        student1 = Student.builder().id(1L).name("Abisayo Peter").build();
        student2 = Student.builder().id(2L).name("Abiodun Peter").build();
        student3 = Student.builder().id(3L).name("Abbey Peter").build();

        report1 = Report.builder().id(1L).student(student1).subject1(23.5).subject2(45.6).subject3(87.7).subject4(76.8).subject5(98.7).build();
        report2 = Report.builder().id(2L).student(student2).subject1(23.5).subject2(45.6).subject3(76.8).subject4(76.8).subject5(98.7).build();
        report3 = Report.builder().id(3L).student(student3).subject1(23.5).subject2(45.6).subject3(87.7).subject4(76.8).subject5(98.7).build();

        reportResponse1 = ReportResponse.builder().report(report1).meanScore(66.46).medianScore(76.8).modeScore(23.5).build();
        reportResponse3 = ReportResponse.builder().report(report3).meanScore(66.46).medianScore(76.8).modeScore(23.5).build();
        reportResponse2 = ReportResponse.builder().report(report2).meanScore(64.28).medianScore(76.8).modeScore(76.8).build();

        reportRequest1 = ReportRequest.builder().studentId(1L).subject1(23.5).subject2(45.6).subject3(87.7).subject4(76.8).subject5(98.7).build();
        reportRequest3 = ReportRequest.builder().studentId(2L).subject1(23.5).subject2(45.6).subject3(76.8).subject4(76.8).subject5(98.7).build();
        reportRequest2 = ReportRequest.builder().studentId(3L).subject1(23.5).subject2(45.6).subject3(87.7).subject4(76.8).subject5(98.7).build();



    }

    @Test
    void getReport() {
        Mockito.when(reportRepository.findAll()).thenReturn(List.of(report1, report2, report3));
        var response = reportService.getReport();
        Assertions.assertThat(response.size()).isEqualTo(3);

    }

    @Test
    void addMultipleReports() {
        DecimalFormat df = new DecimalFormat("0.00");
        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student1));
        Mockito.when(studentRepository.findById(2L)).thenReturn(Optional.of(student2));
        Mockito.when(studentRepository.findById(3L)).thenReturn(Optional.of(student3));
        Mockito.when(reportRepository.save(any())).thenReturn(report1);
        var response = reportService.addMultipleReports(List.of(reportRequest1, reportRequest2, reportRequest3));
        Assertions.assertThat(response.size()).isEqualTo(3);
        Assertions.assertThat(df.format(response.get(0).getMeanScore())).isEqualTo(df.format(reportResponse1.getMeanScore()));
    }

    @Test
    void addSingleReport() {
        DecimalFormat df = new DecimalFormat("0.00");
        Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student1));
        Mockito.when(reportRepository.save(any())).thenReturn(report1);
        var response = reportService.addSingleReport(reportRequest1);
        Assertions.assertThat(df.format(response.getMeanScore())).isEqualTo(df.format(reportResponse1.getMeanScore()));
    }
}