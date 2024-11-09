package org.example.Views;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePathManager {
    final String baseDir;

    public FilePathManager(String baseDir) {
        this.baseDir = baseDir;
    }

    public String getMainExtractPath(String folderName) {
        return baseDir + File.separator + folderName;
    }

    public void createDirectoryIfNotExists(String path) throws IOException {
        Files.createDirectories(Paths.get(path));
    }

    public String getFileNameWithoutExtension(String path) {
        return path.substring(0, path.lastIndexOf('.'));
    }
}
