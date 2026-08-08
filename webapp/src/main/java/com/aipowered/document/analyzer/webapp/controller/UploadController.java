package com.aipowered.document.analyzer.webapp.controller;

import com.aipowered.document.analyzer.webapp.model.UploadedFile;
import com.aipowered.document.analyzer.webapp.repository.UploadedFileRepository;
import com.aipowered.document.analyzer.webapp.service.EmbeddingService;
import com.aipowered.document.analyzer.webapp.service.FileStorageService;
import com.aipowered.document.analyzer.webapp.service.PdfExtractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/api/upload")
@CrossOrigin
@RequiredArgsConstructor
public class UploadController {

    private final FileStorageService fileStorageService;
    private final UploadedFileRepository uploadedFileRepository;
    private final PdfExtractionService pdfExtractionService;
    private final EmbeddingService embeddingService;


    @PostMapping
    public ResponseEntity<?> upload(@RequestParam MultipartFile file) {

        Path path = fileStorageService.save(file);

        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setFileName(file.getOriginalFilename());
        uploadedFile.setMimeType(file.getContentType());
        uploadedFile.setFileSize(file.getSize());
        uploadedFile.setStoragePath(path.toString());

        if ("application/pdf".equalsIgnoreCase(file.getContentType())) {

            uploadedFile.setFileType("PDF");

            String extractedText = pdfExtractionService.extractText(path);
            uploadedFile.setExtractedText(extractedText);

            embeddingService.embedText(extractedText, uploadedFile);
        }



        uploadedFileRepository.save(uploadedFile);

        return ResponseEntity.ok(
                Map.of(
                        "fileId", uploadedFile.getId(),
                        "fileName", uploadedFile.getFileName()
                )
        );
    }

    @GetMapping("/{id}/text")
    public ResponseEntity<?> getExtractedText(@PathVariable UUID id) {

        UploadedFile file = uploadedFileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found"));

        return ResponseEntity.ok(
                Map.of(
                        "length", file.getExtractedText() == null ? 0 : file.getExtractedText().length(),
                        "text", file.getExtractedText()
                )
        );
    }

}
