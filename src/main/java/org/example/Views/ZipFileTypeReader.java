package org.example.Views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipInputStream;

public abstract class ZipFileTypeReader {
    public void readFile(String entryName, ZipInputStream zipInputStream) throws IOException {
        System.out.println("Entry name: " + entryName);
        System.out.println("File: " + entryName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(zipInputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("---- End of " + entryName + " ----\n");
        zipInputStream.closeEntry();
    }
}