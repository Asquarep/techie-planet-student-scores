package com.example.studentsscores.report;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ReportResponse {
    private Report report;
    private Double meanScore;
    private Double medianScore;
    private Double modeScore;
}
