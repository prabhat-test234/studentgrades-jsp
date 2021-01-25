package com.cogbook.grades.contoller;

import com.cogbook.grades.model.ClassAssignments;
import com.cogbook.grades.model.StudentGrade;
import com.cogbook.grades.service.IGradeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradesSheetController {

    private final IGradeService iGradeService;

    public GradesSheetController(IGradeService iGradeService) {
        this.iGradeService = iGradeService;
    }

    @GetMapping("/")
    public String hello(Model model) throws JsonProcessingException {
        ClassAssignments res = iGradeService.getClassAssignment();
        StudentGrade studentGrade = iGradeService.getStudentGrade();
        model.addAttribute("name", res.getClassDetailsList());
        model.addAttribute("grade", studentGrade.getStudentGrade());
        return "hello";
    }
}
