package com.example.studentsscores.report;

import com.example.studentsscores.student.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Student student;
    private Double subject1;
    private Double subject2;
    private Double subject3;
    private Double subject4;
    private Double subject5;
}
