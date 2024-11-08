package org.example;

public interface MarkableContainer {
    MarkableIterator createIterator();

    AssignmentSubmissionIterator getAssignmentSubmissionIterator();
}
