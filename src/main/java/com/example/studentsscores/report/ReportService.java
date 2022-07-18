package com.example.studentsscores.report;

import java.util.List;

public interface ReportService {
    List<ReportResponse> getReport();
    List<ReportResponse> addMultipleReports(List<ReportRequest> reportList);
    ReportResponse addSingleReport(ReportRequest reportRequest);
}
