package com.example.studentsscores.report;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReportRequest {
    private Long studentId;
    private Double subject1;
    private Double subject2;
    private Double subject3;
    private Double subject4;
    private Double subject5;

}
