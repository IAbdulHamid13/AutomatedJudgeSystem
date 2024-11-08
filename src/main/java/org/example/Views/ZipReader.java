package org.example.Views;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipReader {
    private List<String> readNestedZipContent(InputStream zipStream) {
        List<String> files = new ArrayList<>();
        try (ZipInputStream innerZis = new ZipInputStream(zipStream)) {
            ZipEntry innerZipEntry;
            while ((innerZipEntry = innerZis.getNextEntry()) != null) {
                if (innerZipEntry.getName().endsWith(".java")) {
                    System.out.println("Reading java code from " + innerZipEntry.getName());
                    StringBuilder content = new StringBuilder();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(innerZis));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    files.add(content.toString());
                }
            }
            return files;
        } catch (IOException e) {
            throw new RuntimeException("Error reading nested ZIP content", e);
        }
    }

    public List<AssignmentSubmission> createSubmissions(String path) {
        List<AssignmentSubmission> submissions = new ArrayList<>();
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(path))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith(".zip")) {
                    // Create a byte array of the ZIP entry content
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count;
                    while ((count = zis.read(buffer)) != -1) {
                        baos.write(buffer, 0, count);
                    }
                    // Create submission from the nested ZIP
                    AssignmentSubmission submission = new AssignmentSubmission(entry.getName());
                    List<String> assignmentCode = readNestedZipContent(new ByteArrayInputStream(baos.toByteArray()));
                    submission.setAssignmentCode(assignmentCode);
                    submissions.add(submission);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing ZIP file", e);
        }
        return submissions;
    }
}