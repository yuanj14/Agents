package com.czu.langchain4j.controller;

import com.czu.langchain4j.service.ChatService;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@CrossOrigin // 允许跨域
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;
    @Autowired
    private ChatMemoryStore chatMemoryStore;

    @GetMapping(produces = "text/explain;charset=utf-8")
    public Flux<String> aiChat(@RequestParam(value = "message") String message,
                               @RequestParam(value = "memoryId") String memoryId) {
        return chatService.chat(message, memoryId);
    }

    @GetMapping(value = "/history/{memoryId}", produces = "application/json")
    public String getHistory(@PathVariable String memoryId) {
        List<ChatMessage> messages = chatMemoryStore.getMessages(memoryId);
        return ChatMessageSerializer.messagesToJson(messages);
    }
}
