package org.example.TestCreation;

import java.util.ArrayList;

import org.junit.jupiter.api.DynamicTest;

public class TestRunner {
    private ArrayList<ArrayList<DynamicTest>> tests;

    public TestRunner(ArrayList<ArrayList<DynamicTest>> tests) {
        this.tests = tests;
    }

    public void runTests() {

        for(ArrayList<DynamicTest> list : tests){

            for(DynamicTest test : list){

                System.out.println("Name: " + test.getDisplayName());

                try{

                    test.getExecutable().execute();
                    System.out.println("Test case passed!\n");
    
                } catch(Throwable throwable){
    
                    System.out.println("Test case failed!\n");
    
                }

            }

        }
    }
}
