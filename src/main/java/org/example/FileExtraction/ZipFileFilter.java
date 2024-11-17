package org.example.FileExtraction;

public class ZipFileFilter implements FileFilter {
    @Override
    public boolean accept(String fileName) {
        return fileName.endsWith(".zip");
    }
}
