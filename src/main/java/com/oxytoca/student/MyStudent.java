package com.oxytoca.student;

import java.util.Map;

public class MyStudent implements Student {
    String name;
    Boolean enrollment;
    Map<String, Double> reportCard;
    public static final double LOWEST_GRADE = 3.0;


    public void init() {
        enrollment = this.calculateAverageGrade() >= LOWEST_GRADE;
    }

    public String getName() {
        return name;
    }

    public void setEnrollment(Boolean enrollment) {
        this.enrollment = enrollment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReportCard(Map<String, Double> reportCard) {
        this.reportCard = reportCard;
    }

    public MyStudent() {

    }

    public Map<String, Double> getReportCard() {
        return reportCard;
    }

    public MyStudent(String name, Map<String, Double> reportCard) {
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

    @Override
    public String toString() {
        String isTrickyJil = name.equals("Jil") ?
                " (the rector's daughter ┬┴┬┴┤(¬‿¬ )├┬┴┬┴ ) " : "";
        String enrollDecision = enrollment ? " is enrolled in the university " :
            " is not enrolled in the university ";

        return "Student " + name + isTrickyJil +
                " with " + "reportCard=" + reportCard + enrollDecision;
    }
}
