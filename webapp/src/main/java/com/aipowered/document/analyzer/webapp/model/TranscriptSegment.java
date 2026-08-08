package com.aipowered.document.analyzer.webapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "transcript_segments")
@Data
public class TranscriptSegment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private UploadedFile file;

    @Column(columnDefinition = "TEXT")
    private String text;

    private Double startTime; // seconds
    private Double endTime;

    private String topic; // optional, extracted via LLM
}
