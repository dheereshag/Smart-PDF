package com.aipowered.document.analyzer.webapp.repository;

import com.aipowered.document.analyzer.webapp.model.TranscriptSegment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TranscriptSegmentRepository extends JpaRepository<TranscriptSegment, UUID> {
}
