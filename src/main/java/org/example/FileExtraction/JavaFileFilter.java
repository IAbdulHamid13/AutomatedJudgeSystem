package org.example.FileExtraction;

public class JavaFileFilter implements FileFilter {
    @Override
    public boolean accept(String fileName) {
        return fileName.endsWith(".java");
    }
}
