package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TestApi {
    @Autowired
    private SubjectDatabase subjectDatabase;

    @PostMapping(value = "subjects", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addSubject(@RequestBody Subject subject) { subjectDatabase.addSubject(subject); }

    @GetMapping(value = "subjects", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Subject> getSubjects(
            @Nullable @RequestParam("classroom") Integer classroom,
            @Nullable @RequestParam("exam") Boolean exam
    ) {
        return subjectDatabase.getSubjectList(classroom, exam);
    }

    @GetMapping(value = "subjects/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getSubject(@PathVariable("id") Integer id) {
        Subject subject = subjectDatabase.getSubject(id);

        if (subject == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(subject);
    }

    @DeleteMapping(value = "subjects/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteSubject(@PathVariable("id") Integer id) {
        if (subjectDatabase.deleteSubject(id)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "subjects", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSubjects() {
        subjectDatabase.deleteSubjects();
    }
}