package com.example.SpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> list = new ArrayList<>(List.of(
            new Student(1, "joe", 89),
            new Student(2,"mart",35)
    ));

    // return list of all students
    @GetMapping(path = "/student")
    public List<Student> getStudents() {
        return list;
    }

    // post a new student
    @PostMapping(path = "/student")
    public Student addStudent(@RequestBody Student student) {
        if (student.)
        list.add(student);
    }
}
