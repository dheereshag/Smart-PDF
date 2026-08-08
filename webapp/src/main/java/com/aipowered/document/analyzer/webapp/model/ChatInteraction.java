package com.aipowered.document.analyzer.webapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "chat_interactions")
@Data
public class ChatInteraction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private UploadedFile file;

    private String question;

    @Column(columnDefinition = "TEXT")
    private String answer;

    private Double referencedTimestamp;

    @CreationTimestamp
    private LocalDateTime askedAt;
}

