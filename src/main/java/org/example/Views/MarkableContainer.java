package org.example.Views;

interface MarkableContainer {
    MarkableIterator createIterator();

    AssignmentSubmissionIterator getAssignmentSubmissionIterator();
}
