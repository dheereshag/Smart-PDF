package com.aipowered.document.analyzer.webapp.repository;

import com.aipowered.document.analyzer.webapp.model.ChatInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatInteractionRepository extends JpaRepository<ChatInteraction, UUID> {
}
