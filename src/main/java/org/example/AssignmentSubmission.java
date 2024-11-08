package org.example;

import java.util.ArrayList;
import java.util.List;

public class AssignmentSubmission {
    private String zipName; // Name of the zip file
    private int score; // Score for this submission
    private List<String> AssignmentCode;

    public AssignmentSubmission(String zipName) {
        setZipName(zipName);
        setScore(0);
        AssignmentCode = new ArrayList<>();
    }

    public String getZipName() {
        return zipName;
    }

    public void setZipName(String zipName) {
        this.zipName = zipName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getAssignmentCode() {
        return AssignmentCode;
    }

    public void setAssignmentCode(List<String> assignmentCode) {
        AssignmentCode = assignmentCode;
    }
}