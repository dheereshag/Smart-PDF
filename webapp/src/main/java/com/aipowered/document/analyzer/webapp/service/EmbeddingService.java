package com.aipowered.document.analyzer.webapp.service;

import com.aipowered.document.analyzer.webapp.model.UploadedFile;
import dev.langchain4j.data.segment.TextSegment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class EmbeddingService {

    private final List<TextSegment> segments = new ArrayList<>();

    public void embedText(String text, UploadedFile file) {
        List<TextSegment> chunks = chunk(text);
        segments.addAll(chunks);
        System.out.println("Stored text chunks = " + chunks.size());
    }

    public List<TextSegment> search(String query, int topK) {
        String q = query.toLowerCase();
        return segments.stream()
                .filter(s -> s.text().toLowerCase().contains(q))
                .limit(topK)
                .toList();
    }

    private List<TextSegment> chunk(String text) {
        List<TextSegment> result = new ArrayList<>();
        int chunkSize = 800;

        for (int i = 0; i < text.length(); i += chunkSize) {
            int end = Math.min(text.length(), i + chunkSize);
            result.add(TextSegment.from(text.substring(i, end)));
        }
        return result;
    }
}


