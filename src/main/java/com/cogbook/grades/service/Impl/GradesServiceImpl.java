package com.cogbook.grades.service.Impl;

import com.cogbook.grades.model.ClassAssignments;
import com.cogbook.grades.model.ClassDetails;
import com.cogbook.grades.model.StudentDetails;
import com.cogbook.grades.model.StudentGrade;
import com.cogbook.grades.service.IGradeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.tags.form.SelectTag;

import java.util.*;

@Service
public class GradesServiceImpl implements IGradeService {
    private String gradeUrl = "https://9hu0ztgsi6.execute-api.us-east-2.amazonaws.com/test/student/grade/";

    @Override
    public ClassAssignments getClassAssignment() throws JsonProcessingException {
        ClassAssignments classAssignments = new ClassAssignments();
        List<ClassDetails> classDetailsList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(gradeUrl , String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        int n = root.get("clsassignments").size();
        for(int i =0;i<n;i++) {
            ClassDetails classDetails = new ClassDetails();
            classDetails.setSectionId(root.get("clsassignments").get(i).get("sectionid").asInt());
            classDetails.setSectionName(root.get("clsassignments").get(i).get("sectionname").asText());
            classDetailsList.add(classDetails);
        }
        classAssignments.setClassDetailsList(classDetailsList);
        return classAssignments;
    }

    @Override
    public StudentGrade getStudentGrade() throws JsonProcessingException {
        StudentGrade studentGrade = new StudentGrade();
        List<StudentDetails> studentDetailsList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(gradeUrl , String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        int n = root.get("gradedata").size();
        Set<Integer> uniSt = new HashSet<>();
        for(int i =0;i<n;i++) {
            if(!uniSt.contains(root.get("gradedata").get(i).get("studentid").asInt())) {
                StudentDetails studentDetails = new StudentDetails();
                studentDetails.setStudentId(root.get("gradedata").get(i).get("studentid").asText());
                studentDetails.setStudentName(root.get("gradedata").get(i).get("studentName").asText());
                int m = root.get("gradedata").get(i).get("grades").size();
                Map<Integer, String> res = new HashMap<>();
                for(int j = 0;j<m;j++) {
                    int id = root.get("gradedata").get(i).get("grades").get(j).get("sectionid").asInt();
                    String gradePer = root.get("gradedata").get(i).get("grades").get(j).get("gradePer").asText();

                    res.put(id,gradePer);

                }
                studentDetails.setMarks(res);
                studentDetailsList.add(studentDetails);
                studentGrade.setStudentGrade(studentDetailsList);
                uniSt.add(root.get("gradedata").get(i).get("studentid").asInt());
            }

        }
        return studentGrade;
    }
}
