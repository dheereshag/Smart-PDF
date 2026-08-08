package com.aipowered.document.analyzer.webapp.controller;

import com.aipowered.document.analyzer.webapp.service.EmbeddingService;
import dev.langchain4j.data.segment.TextSegment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@CrossOrigin
public class ChatController {

    private final EmbeddingService embeddingService;

    @PostMapping
    public Map<String, Object> chat(@RequestBody Map<String, String> body) {

        String question = body.get("question");

        List<TextSegment> matches = embeddingService.search(question, 3);

        String answer = matches.isEmpty()
                ? "No relevant content found in uploaded documents."
                : matches.get(0).text();

        return Map.of(
                "question", question,
                "answer", answer,
                "chunksUsed", matches.size()
        );
    }
}
