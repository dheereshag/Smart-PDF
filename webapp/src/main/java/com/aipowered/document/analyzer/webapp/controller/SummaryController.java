package com.aipowered.document.analyzer.webapp.controller;

import com.aipowered.document.analyzer.webapp.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SummaryController {
    @Autowired
    private SummaryService summaryService;
}
