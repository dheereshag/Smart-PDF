package com.aipowered.document.analyzer.webapp.service;

import dev.langchain4j.service.SystemMessage;

public interface Assistant {

    @SystemMessage("Answer questions using the uploaded document content.")
    String chat(String userMessage);
}