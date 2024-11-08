package org.example;

import java.util.List;

public class AssignmentSubmissionIterator implements MarkableIterator {
    private final List<AssignmentSubmission> submissions;
    private int currentIndex;

    public AssignmentSubmissionIterator(List<AssignmentSubmission> submissions) {
        this.submissions = submissions;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < submissions.size();
    }

    @Override
    public AssignmentSubmission next() {
        if (hasNext()) {
            return submissions.get(currentIndex++);
        }
        return null;
    }
}
