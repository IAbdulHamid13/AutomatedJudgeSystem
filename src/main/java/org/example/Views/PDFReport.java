package org.example.Views;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class PDFReport implements ReportGenerator {
    private String content;
    private String destination;

    public PDFReport(String content, String destination) {
        this.content = content;
        this.destination = destination;
    }

    public void generateReport() {
        try {
            PdfWriter writer = new PdfWriter(destination + "/report.pdf");
            PdfDocument reportPDF = new PdfDocument(writer);
            Document reportDoc = new Document(reportPDF);
            PdfFont reportFont = PdfFontFactory.createRegisteredFont("courier");
            Paragraph reportContent = new Paragraph(content);
            reportContent.setFont(reportFont);
            reportDoc.add(reportContent);
            reportDoc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
