package com.github.clarakraus.stspringexperience;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test

    void shouldReturnStudent(){
        //given
        StudentRepository studentrepo = Mockito.mock(StudentRepository.class);
        StudentService studentservice = new StudentService(studentrepo);
        Student student = new Student("Clara");
        Mockito.when(studentrepo.findStudent("121212")).thenReturn(Optional.of(student));
        //when
        Optional<Student> actual = studentservice.getStudent("121212");
        //then

        Assertions.assertThat(actual).contains(student);
    }
    @Test

    void shouldReturnEmpty(){
        //given
        StudentRepository studentrepo = Mockito.mock(StudentRepository.class);
        StudentService studentservice = new StudentService(studentrepo);
        Student student = new Student("Clara");
        Mockito.when(studentrepo.findStudent("1212456789012")).thenReturn(Optional.of(student));
        //when
        Optional<Student> actual = studentservice.getStudent("121212");
        //then

        Assertions.assertThat(actual).isEmpty();
    }


    @Test
    void shouldAddStudent(){
        StudentRepository studentrepo = Mockito.mock(StudentRepository.class);
        StudentService studentservice = new StudentService(studentrepo);
        Student student = new Student("Clara");
        //when
            Mockito.verify(studentrepo).save(student);
    }

    @Test
    void shouldReturnAll(){
        StudentRepository studentrepo = Mockito.mock(StudentRepository.class);
        StudentService studentservice = new StudentService(studentrepo);
        Student student1 = new Student("Clara");
        Student student2 = new Student("Kevin");
        Map<String, Student> liste = new HashMap<>();
        liste.put(student1.getId(), student1);
        liste.put(student2.getId(), student2);
        Mockito.when(studentrepo.findAll()).thenReturn(List.of(student1, student2));
        //when
        Collection<Student> actual = studentservice.list();
        //then
        Assertions.assertThat(actual).containsAll(List.of(student1, student2));

    }

}