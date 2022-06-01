package com.github.clarakraus.stspringexperience;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final StudentRepository stRepo;


    public StudentService(StudentRepository stRepo) {
        this.stRepo = stRepo;
    }

    public Optional<Student> getStudent(String id) {
        return stRepo.findStudent(id);

    }

    public Collection<Student> list() {
        return stRepo.findAll();
    }

    public void addStudent(Student student) {
        stRepo.save(student);
    }
}
