package org.example.FileExtraction;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileExtractor implements FileExtractor {
    private final org.example.FileExtraction.FileFilter fileFilter;
    private final int bufferSize;

    public ZipFileExtractor(org.example.FileExtraction.FileFilter fileFilter, int bufferSize) {
        this.fileFilter = fileFilter;
        this.bufferSize = bufferSize;
    }

    @Override
    public void extract(String sourcePath, String targetPath) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(sourcePath))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (!shouldExtractEntry(entry)) continue;
                extractEntry(zis, entry, targetPath);
            }
        }
    }

    private boolean shouldExtractEntry(ZipEntry entry) {
        return !entry.isDirectory() && fileFilter.accept(entry.getName());
    }

    private void extractEntry(ZipInputStream zis, ZipEntry entry, String targetPath) throws IOException {
        String fileName = new File(entry.getName()).getName();
        Path filePath = Paths.get(targetPath, fileName);
        Files.createDirectories(filePath.getParent());

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath.toString()))) {
            byte[] buffer = new byte[bufferSize];
            int count;
            while ((count = zis.read(buffer)) != -1) {
                bos.write(buffer, 0, count);
            }
        }
    }
}
