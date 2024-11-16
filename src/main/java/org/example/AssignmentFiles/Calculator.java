package org.example.AssignmentFiles;

public class Calculator {

    private String brand = "CASIO";
    public int model = 1;
    private static Boolean isScientific;
    final private static int pizza = 0;

    public Calculator(){

    }

    public Calculator(int a){

    }

    public Calculator(String a){
        
    }

    public Calculator(Boolean a){
        
    }

    private final String getBrand(String a){return brand;}
    protected static Boolean isScientific(Boolean a){return isScientific;}

    public int add(int a, int b){

        return a + b;

    }
    
}
