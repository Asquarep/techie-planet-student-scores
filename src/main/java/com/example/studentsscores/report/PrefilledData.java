package com.example.studentsscores.report;

import com.example.studentsscores.student.Student;
import com.example.studentsscores.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PrefilledData {
    private final StudentRepository studentRepository;

    @PostConstruct
    public void Create() {
        Student student1 = Student.builder().id(1L).name("Abisayo Peter").build();
        Student student2 = Student.builder().id(2L).name("Abiodun Peter").build();
        Student student3 = Student.builder().id(3L).name("Abbey Peter").build();

        studentRepository.saveAll(List.of(student1, student2, student3));

    }
}
