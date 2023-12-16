package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        int number = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                count++;
                number += subject.score();
            }
        }
        return (double) number / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int count = 0;
            int number = 0;
            for (Subject subject : pupil.subjects()) {
                count++;
                number += subject.score();
            }
            labels.add(new Label(pupil.name(), (double) number / count));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> one = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        int count = 0;
        for (Pupil pupil : pupils) {
            count++;
            for (Subject subject : pupil.subjects()) {
                one.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (String key : one.keySet()) {
            labels.add(new Label(key, (double) one.get(key) / count));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Map<String, Integer> one = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                one.merge(pupil.name(), subject.score(), Integer::sum);
            }
        }
        for (String key : one.keySet()) {
            labels.add(new Label(key, (double) one.get(key)));
        }
        return Collections.max(labels);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> one = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                one.put(subject.name(), subject.score() + one.getOrDefault(subject.name(), 0));
            }
        }
        for (String key : one.keySet()) {
            labels.add(new Label(key, (double) one.get(key)));
        }
        return Collections.max(labels);
    }
}
