package org.example.TestCreation;


import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class TestMarker {

    @Setter private TestMaker testMaker;
    @Setter private TestRunner testRunner;
    @Setter private AssignmentSpec aSpec;
    @Getter private ArrayList<String> results;

    public TestMarker(){

        testMaker = new TestMaker();
        testRunner = new TestRunner();

    }

    public TestMarker(AssignmentSpec spec){

        this.aSpec = spec;
        results = new ArrayList<String>();
        testMaker = new TestMaker(aSpec);
        testRunner = new TestRunner(testMaker.createTests());
        testRunner.runTests();

    }

    //Loads results into results hash map

    public void markTests(){

        ArrayList<AssignmentJava> javaFiles = aSpec.getSpecFiles();

        for(AssignmentJava j : javaFiles){

            for(Testable property : j.getProperties()){

                int[] marks = {1, 2};

                marks[0] = property.getMarksAwarded();
                marks[1] = property.getMarksWorth();


                try{

                    results.add(property.getName());
                    results.add(Integer.toString(property.getMarksAwarded()));
                    results.add(Integer.toString(property.getMarksWorth()));

                } catch(NullPointerException e){
                    System.out.println(e);
                }

            }

        }

    }

    public void printResults(){

        for(int i = 0;i <= results.size() - 3; i = i + 3){

            System.out.println("Property tested for: " + results.get(i));
            System.out.println("Marks earned: " + results.get(i + 1) + "/" + results.get(i + 2) + "\n");

        }

    }
    
}
