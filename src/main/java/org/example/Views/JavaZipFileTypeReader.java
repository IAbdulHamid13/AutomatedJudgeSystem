package org.example.Views;

import java.io.IOException;
import java.util.zip.ZipInputStream;

public class JavaZipFileTypeReader extends ZipFileTypeReader {
    public void readFile(String entryName, ZipInputStream zipInputStream) throws IOException {
        if (entryName.endsWith(".java")) {
            super.readFile(entryName, zipInputStream);
        }
    }
}