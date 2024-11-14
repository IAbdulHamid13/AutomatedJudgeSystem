package org.example.Views;

import org.example.AssignmentFiles.Calculator;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World"); //keep this to make sure the project still runs.

        try{
            
            Class<?> c = Class.forName("Calculator");


        } catch (Exception e){

            System.out.println(e);

        }

    }
}