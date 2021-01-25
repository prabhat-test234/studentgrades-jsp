package com.cogbook.grades.model;

import org.springframework.stereotype.Component;

@Component
public class ClassDetails {
    private Integer sectionId;
    private String sectionName;

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
