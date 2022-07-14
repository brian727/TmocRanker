package com.briansdigital.p1TmocRunRanker.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {

        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents() {

        return studentRepo.findAll();
    }

    public void addNewStudent(Student student) {
        System.out.println(student);
    }
}
