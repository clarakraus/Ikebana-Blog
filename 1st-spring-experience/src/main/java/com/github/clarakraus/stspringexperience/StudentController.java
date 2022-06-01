package com.github.clarakraus.stspringexperience;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")

public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Student> studentList(){
        return service.list();
    }
    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable String id){
        return service.getStudent(id);
    }
    @PostMapping
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }

}
