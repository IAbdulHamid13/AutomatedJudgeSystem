package org.example.FileExtraction;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipExtractor {
    private final FilePathManager pathManager;
    private final FileExtractor studentZipExtractor;
    private final org.example.FileExtraction.FileFilter zipFileFilter;
    private final int bufferSize;

    public ZipExtractor(String destinationDirectory, int bufferSize) {
        this.pathManager = new FilePathManager(destinationDirectory);
        this.zipFileFilter = new ZipFileFilter();
        this.studentZipExtractor = new ZipFileExtractor(new JavaFileFilter(), bufferSize);
        this.bufferSize = bufferSize;
    }

    public void extractZipFile(String AssignmentSourcePath) throws IOException {
        validateZipFile(AssignmentSourcePath);
        String mainExtractPath = setupExtractionDirectory();

        try (ZipFile zip = new ZipFile(AssignmentSourcePath)) {
            processZipEntries(zip, mainExtractPath);
        }
    }

    private void validateZipFile(String zipFilePath) throws IOException {
        File zipFile = new File(zipFilePath);
        if (!zipFile.exists()) {
            throw new FileNotFoundException("Zip file not found: " + zipFilePath);
        }
    }

    private String setupExtractionDirectory() throws IOException {
        pathManager.createDirectoryIfNotExists(pathManager.baseDir);
        String mainExtractPath = pathManager.getMainExtractPath("assignments");
        pathManager.createDirectoryIfNotExists(mainExtractPath);
        return mainExtractPath;
    }

    private void processZipEntries(ZipFile zip, String mainExtractPath) throws IOException {
        Enumeration<? extends ZipEntry> entries = zip.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            if (zipFileFilter.accept(entry.getName())) {
                processStudentZip(zip, entry, mainExtractPath);
            }
        }
    }

    private void processStudentZip(ZipFile zip, ZipEntry entry, String mainExtractPath) throws IOException {
        String studentZipPath = mainExtractPath + File.separator + entry.getName();
        extractZipEntry(zip, entry, studentZipPath);

        String studentFolder = pathManager.getFileNameWithoutExtension(studentZipPath);
        studentZipExtractor.extract(studentZipPath, studentFolder);

        Files.deleteIfExists(Paths.get(studentZipPath));
    }

    private void extractZipEntry(ZipFile zip, ZipEntry entry, String targetPath) throws IOException {
        Files.createDirectories(Paths.get(targetPath).getParent());
        try (InputStream is = zip.getInputStream(entry); FileOutputStream fos = new FileOutputStream(targetPath)) {
            byte[] buffer = new byte[bufferSize];
            int len;
            while ((len = is.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        }
    }
}