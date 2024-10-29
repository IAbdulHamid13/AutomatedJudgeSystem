package org.example.Views;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World"); //keep this to make sure the project still runs.
        JavaZipFileTypeReader reader = new JavaZipFileTypeReader();
        ZipReader zr = new ZipReader(reader);
        zr.parseFile("C:\\Users\\Isaab\\OneDrive\\Desktop\\comp3607groupproject\\readThis.zip");
    }
}