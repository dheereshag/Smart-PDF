package com.aipowered.document.analyzer.webapp.repository;

import com.aipowered.document.analyzer.webapp.model.UploadedFile;
import com.aipowered.document.analyzer.webapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
