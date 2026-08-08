package com.aipowered.document.analyzer.webapp.service;

import org.springframework.stereotype.Service;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.nio.file.Path;

@Service
public class PdfExtractionService {

    public String extractText(Path pdfPath) {
        try (PDDocument document = PDDocument.load(pdfPath.toFile())) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            System.out.println("PDF extracted length = " + text.length());

            return text;
        } catch (IOException e) {
            throw new RuntimeException("Failed to extract text from PDF", e);
        }
    }
}
