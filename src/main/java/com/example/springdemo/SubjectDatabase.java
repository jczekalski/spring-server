package com.example.springdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class SubjectDatabase {
    private List<Subject> subjectList = new ArrayList<>();

    private int subjectIndex = 1;

    public List<Subject> getSubjectList(Integer classroom, Boolean exam) {
        if (classroom == null && exam == null) {
            return subjectList;
        }
        List<Subject> filteredSubjects = new ArrayList<>();
        for (Subject subject : subjectList) {
            if (classroom == null && subject.getExam().equals(exam)
                    || exam == null && subject.getClassroom().equals(classroom)
                    || subject.getExam().equals(exam) && subject.getClassroom().equals(classroom)
            ) {
                filteredSubjects.add(subject);
            }
        }
        return filteredSubjects;
    }

    public void addSubject(Subject subject) {
        subject.setId(subjectIndex);
        subjectIndex++;
        subjectList.add(subject);
    }

    public void deleteSubjects() {
        subjectList.clear();
    }

    public Subject getSubject(Integer id) {
        for (Subject subject : subjectList) {
            if (subject.getId().equals(id)) {
                return subject;
            }
        }
        return null;
    }

    public Boolean deleteSubject(Integer id) {
        Subject subjectToDelete = null;
        for (Subject subject : subjectList) {
            if (subject.getId().equals(id)) {
                subjectToDelete = subject;
            }
        }

        if (subjectToDelete == null) {
            return false;
        }
        subjectList.remove(subjectToDelete);
        return true;
    }
}
