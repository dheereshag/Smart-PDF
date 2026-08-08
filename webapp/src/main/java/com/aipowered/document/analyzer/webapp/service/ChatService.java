package com.aipowered.document.analyzer.webapp.service;

import dev.langchain4j.data.segment.TextSegment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final EmbeddingService embeddingService;

    public ChatService(EmbeddingService embeddingService) {
        this.embeddingService = embeddingService;
    }

    public String ask(String question) {

        List<TextSegment> segments =
                embeddingService.search(question, 5);

        if (segments.isEmpty()) {
            return "I don't know based on the uploaded document.";
        }

        StringBuilder answer = new StringBuilder();
        answer.append("Based on the document:\n\n");

        for (TextSegment s : segments) {
            answer.append("- ").append(s.text()).append("\n\n");
        }

        return answer.toString();
    }
}
