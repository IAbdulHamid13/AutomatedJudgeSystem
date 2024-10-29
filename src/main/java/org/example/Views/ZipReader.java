package org.example.Views;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipReader implements FileReader {
    private final ZipFileTypeReader fileTypeReader;

    public ZipReader(ZipFileTypeReader fileTypeReader) {
        this.fileTypeReader = fileTypeReader;
    }

    @Override
    public void parseFile(String directory) {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(directory))) {
            processZipStream(zipInputStream);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private void processZipStream(ZipInputStream zipInputStream) throws IOException {
        ZipEntry entry;
        while ((entry = zipInputStream.getNextEntry()) != null) {
            String entryName = entry.getName();

            if (entryName.endsWith(".zip")) {
                // Handle nested zip by reading it into memory first
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int len;
                while ((len = zipInputStream.read(buffer)) > 0) {
                    baos.write(buffer, 0, len);
                }

                // Process the nested zip
                try (ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray()); ZipInputStream nestedZipInputStream = new ZipInputStream(bais)) {
                    System.out.println("Reading nested zip file: " + entryName);
                    processZipStream(nestedZipInputStream);
                }
            }
            fileTypeReader.readFile(entryName, zipInputStream); //We can now read any File type within the zip, we just need to create a constructor for that .filetype
            zipInputStream.closeEntry();
        }
    }
}
