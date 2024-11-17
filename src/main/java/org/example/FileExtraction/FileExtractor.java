package org.example.FileExtraction;

import java.io.IOException;

interface FileExtractor {
    void extract(String sourcePath, String targetPath) throws IOException;
}
