package org.example.TestCreation;


import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import org.example.Views.PDFReport;

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

            results.add("File: " + j.getName());

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

        StringBuilder finalOutput = new StringBuilder();

        int i = 0;

        while (i < results.size()) {
            String entry = results.get(i);
            
            if (entry.startsWith("File: ")) { // Check if the entry is a file header

                finalOutput.append(entry).append("\n\n");

                System.out.println(entry + "\n\n");
                i++;
            } else {
                
                String propertyTested = "Property tested for: " + results.get(i);
                String marksEarned = "Marks earned: " + results.get(i + 1) + "/" + results.get(i + 2) + "\n";

                finalOutput.append(propertyTested).append("\n").append(marksEarned).append("\n");
                System.out.println(propertyTested);
                System.out.println(marksEarned);

                i += 3;
            }
        }

        System.out.println("Final Output (the String):\n" + finalOutput.toString());

        //create report below

        PDFReport pdf = new PDFReport(finalOutput.toString(), "src\\\\main\\\\java\\\\org\\\\example\\\\AssignmentFiles");
        pdf.generateReport();  //assumed that the same location referred to where the zip files were extracted


    }

}
