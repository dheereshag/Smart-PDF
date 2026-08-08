package com.aipowered.document.analyzer.webapp.controller;

import com.aipowered.document.analyzer.webapp.service.PdfExtractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MediaController {

    @Autowired
    private PdfExtractionService pdfExtractionService;
}
