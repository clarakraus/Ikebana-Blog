package com.github.clarakraus.stspringexperience;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class StudentRepository {

    Map<String, Student> students = new HashMap<>();

    public Optional<Student> findStudent(String id) {
        return Optional.ofNullable(students.get(id));
    }

    public Collection<Student> findAll(){
        return students.values();
    }

    public void save(Student student){
        students.put(student.getId(), student);
    }
}



