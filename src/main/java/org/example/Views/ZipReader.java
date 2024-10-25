package org.example.Views;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipReader implements FileReader {
    @Override
    public void parseFile(String directory) {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(directory))) {
            ZipEntry entry;
            String entryName;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                entryName = entry.getName();
                if (entryName.contains(".java")) { //Will only read the .java files from the project
                    System.out.println("Entry name: " + entryName);
                    System.out.println("File: " + entry.getName());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(zipInputStream));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    System.out.println("---- End of " + entry.getName() + " ----\n");
                    zipInputStream.closeEntry();
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
