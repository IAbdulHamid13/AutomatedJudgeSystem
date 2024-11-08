package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AssignmentContainer implements MarkableContainer {
    private final String path; // Path to the main submissions zip file
    private List<AssignmentSubmission> submissions = new ArrayList<>();

    public AssignmentContainer(String path) {
        this.path = path;
        indexAssignments();
    }

    public void indexAssignments() {
        ZipReader reader = new ZipReader();
        File submissionsZip = new File(path);
        try {
            if (submissionsZip.exists() && submissionsZip.isFile()) {
                submissions = reader.createSubmissions(path);
                System.out.println("Submissions processed successfully.");
            } else {
                throw new FileNotFoundException("File does not exist or is not a valid file: " + path);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    @Override
    public MarkableIterator createIterator() {
        return new AssignmentSubmissionIterator(submissions);
    }

    @Override
    public AssignmentSubmissionIterator getAssignmentSubmissionIterator() {
        return new AssignmentSubmissionIterator(submissions);
    }
}