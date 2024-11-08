package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileManipulator {
    public void createFile(String filetype, AssignmentSubmission submission) throws IOException {
        final String BASE_DIR = System.getProperty("user.dir") + "/src/main/java/com/example/TestCode";
        String submissionDir = BASE_DIR + File.separator + submission.getZipName();
        File directory = new File(submissionDir);
        if (!directory.exists()) directory.mkdirs();
        for (String code : submission.getAssignmentCode()) {
            String fileName = "Class" + submission.getAssignmentCode().indexOf(code) + 1 + +'.' + filetype;
            Path filePath = Paths.get(submissionDir, fileName);
            try (FileWriter fileWriter = new FileWriter(filePath.toFile())) {
                fileWriter.write(code);
            } catch (IOException e) {
                System.err.println("Error writing file: " + filePath);
                e.printStackTrace();
            }
        }
    }

    public void clearTestCodeDirectory() {
        final String BASE_DIR = System.getProperty("user.dir") + "/src/main/java/com/example/TestCode";
        Path baseDirPath = Paths.get(BASE_DIR);
        try {
            Files.walkFileTree(baseDirPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            System.err.println("Error clearing directory: " + e.getMessage());
        } finally {
            System.out.println("Clear Test Code Directory has been run.");
        }
    }
}
