package org.example.TestCreation;

import org.junit.jupiter.api.DynamicTest;

public interface Testable {
    public String getName();
    public int getMarksWorth();
    public int getMarksAwarded();
    public DynamicTest generateTest();
}
