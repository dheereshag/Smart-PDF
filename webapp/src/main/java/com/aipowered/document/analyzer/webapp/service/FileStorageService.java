package com.aipowered.document.analyzer.webapp.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;

@Service
public class FileStorageService {
    private final Path rootLocation;

    public FileStorageService(@Value("${app.storage.path}") String storagePath) {
        this.rootLocation = Paths.get(storagePath);
        init();
    }

    private void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage", e);
        }
    }

    public Path save(MultipartFile file) {
        try {
            String originalName = file.getOriginalFilename();
            String safeFileName =
                    java.util.UUID.randomUUID() + "_" +
                            (originalName != null ? originalName : "file");

            Path destination = rootLocation.resolve(safeFileName);

            Files.copy(
                    file.getInputStream(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

            return destination;

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

}
