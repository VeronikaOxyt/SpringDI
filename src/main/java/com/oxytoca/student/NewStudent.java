package com.oxytoca.student;

import java.util.Map;

public class NewStudent implements Student {
    String name;
    Boolean enrollment;
    Map<String, Double> reportCard;
    public static final double LOWEST_GRADE = 3.0;

    public void init() {
        enrollment = this.calculateAverageGrade() >= LOWEST_GRADE;
        System.out.println("init");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReportCard(Map<String, Double> reportCard) {
        this.reportCard = reportCard;
    }

    public NewStudent() {

    }

    public Map<String, Double> getReportCard() {
        return reportCard;
    }

    public NewStudent(String name, Map<String, Double> reportCard) {
        this.name = name;
        this.reportCard = reportCard;
    }

    private double calculateAverageGrade() {
        return reportCard
                .values()
                .stream()
                .mapToDouble(a -> a)
                .average()
                .orElse(0.0);
    }
}
