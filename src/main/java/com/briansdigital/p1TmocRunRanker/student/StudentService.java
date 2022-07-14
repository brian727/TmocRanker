package com.briansdigital.p1TmocRunRanker.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepo.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exist!");
        }
        studentRepo.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + " does not exist!"
        ));
                if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
                    student.setName(name);
                }
                if(email !=null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
                    Optional<Student> studentOptional = studentRepo.findStudentByEmail(email);
                    if (studentOptional.isPresent()) {
                        throw new IllegalStateException("email taken!");
                    }
                    student.setEmail(email);
                }
    }
}
