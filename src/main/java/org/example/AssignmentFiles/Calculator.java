package org.example.AssignmentFiles;

public class Calculator {

    String brand = "CASIO";
    int model = 1;
    static Boolean isScientific;
    static int pizza = 0;

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
