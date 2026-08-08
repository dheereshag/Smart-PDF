package com.aipowered.document.analyzer.webapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "document_contents")
@Data
public class DocumentContent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private UploadedFile file;

    @Column(columnDefinition = "TEXT")
    private String contentText;

    private String summary;
}

