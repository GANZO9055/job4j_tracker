package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        for (Student student : students.keySet()) {
            if (student.account().equals(account)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> student = findByAccount(account);
        if (student.isPresent()) {
            Set<Subject> subjects = students.get(student.get());
            for (Subject subject : subjects) {
                if (subject.name().equals(name)) {
                    return Optional.of(subject);
                }
            }
        }
        return Optional.empty();
    }
}
