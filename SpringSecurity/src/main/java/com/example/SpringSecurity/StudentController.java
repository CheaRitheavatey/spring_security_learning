package com.example.SpringSecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
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
        list.add(student);
        return student;
    }

    // in order to post sth we need a token for it to access so make a method to give the token
    @GetMapping(path = "/token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
