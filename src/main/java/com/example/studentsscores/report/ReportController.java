package com.example.studentsscores.report;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    @GetMapping("/get-report")
    public List<ReportResponse> getReport(){
        return reportService.getReport();
    }
    @PostMapping("/add-single-report")
    public ReportResponse addSingleReport(@RequestBody ReportRequest reportRequest){
        return reportService.addSingleReport(reportRequest);
    }
    @PostMapping("/add-multiple-reports")
    public List<ReportResponse> addMultipleReports(@RequestBody List<ReportRequest> reportRequest){
        return reportService.addMultipleReports(reportRequest);
    }
}
