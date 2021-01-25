package com.cogbook.grades.service;

import com.cogbook.grades.model.ClassAssignments;
import com.cogbook.grades.model.StudentGrade;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IGradeService {
    ClassAssignments getClassAssignment() throws JsonProcessingException;
    StudentGrade getStudentGrade() throws JsonProcessingException;
}
