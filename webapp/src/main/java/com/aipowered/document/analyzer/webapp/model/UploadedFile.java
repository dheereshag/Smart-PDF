package com.aipowered.document.analyzer.webapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "uploaded_files")
@Data
public class UploadedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fileName;
    private String fileType; // PDF, AUDIO, VIDEO
    private String mimeType;

    private String storagePath; // where file is saved

    private Long fileSize;

    @ManyToOne
    private User user;

    @CreationTimestamp
    private LocalDateTime uploadedAt;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String extractedText;
}
