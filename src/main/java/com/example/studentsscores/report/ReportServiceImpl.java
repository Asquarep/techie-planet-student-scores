package com.example.studentsscores.report;

import com.example.studentsscores.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{
    private final ReportRepository reportRepository;
    private final StudentRepository studentRepository;

    @Transactional
    @Override
    public List<ReportResponse> getReport() {
        var list = reportRepository.findAll();
        List<ReportResponse> response = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            var report = list.get(i);
            var stats = getStats(report);
           var response1 = ReportResponse.builder().report(report).meanScore(stats[0]).medianScore(stats[1]).modeScore(stats[2]).build();
            response.add(response1);
        }

        return response;
    }

    private double[] getStats(Report report){
        double [] result = new double[3];
        double mean, median, mode;
        var stream = List.of(
                report.getSubject1(),
                report.getSubject2(),
                report.getSubject3(),
                report.getSubject4(),
                report.getSubject5()
        );
        mean =  stream.stream().reduce(0.0, Double::sum)/5;
        var sorted = stream.stream().sorted().toList();
        median = sorted.get(2);
        HashMap<Double, Double> map = new HashMap<>();
        double maxOccurrences = 0.0;
        mode = -1;
        for (double num : sorted) {
            map.merge(num, 1.0, Double::sum);
            double occurrences = map.get(num);
            if (occurrences > maxOccurrences || (occurrences == maxOccurrences && num < mode)) {
                maxOccurrences = occurrences;
                mode = num;
            }
        }
        result[0] = mean;
        result[1] = median;
        result[2] = mode;

        return result;
    }
    @Transactional
    @Override
    public List<ReportResponse> addMultipleReports(List<ReportRequest> reportList) {
        List<ReportResponse> response = new ArrayList<>();
        for (var each : reportList) {
            var report = addSingleReport(each);
            response.add(report);
        }
        return response;
    }

    @Transactional
    @Override
    public ReportResponse addSingleReport(ReportRequest reportRequest) {
        var student = studentRepository.findById(reportRequest.getStudentId());
        if (student.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        var report = Report.builder().student(student.get())
                .subject1(reportRequest.getSubject1())
                .subject2(reportRequest.getSubject2())
                .subject3(reportRequest.getSubject3())
                .subject4(reportRequest.getSubject4())
                .subject5(reportRequest.getSubject5()).build();

        var saved = reportRepository.save(report);
        var stats = getStats(saved);
        return ReportResponse.builder().report(saved).meanScore(stats[0]).medianScore(stats[1]).modeScore(stats[2]).build();
    }

}
