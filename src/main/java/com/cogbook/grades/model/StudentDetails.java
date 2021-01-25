package com.cogbook.grades.model;

import java.util.Map;

public class StudentDetails {
    private String studentName;
    private String studentId;
    private Map<Integer, String> marks;

    public Map<Integer, String> getMarks() {
        return marks;
    }

    public void setMarks(Map<Integer, String> marks) {
        this.marks = marks;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
