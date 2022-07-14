package com.briansdigital.p1TmocRunRanker.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Student> studentOptional = studentRepo.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepo.save(student);
    }
}
