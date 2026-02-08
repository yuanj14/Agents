package com.czu.langchain4j.service;

import com.czu.langchain4j.tool.TimeTool;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

@AiService(tools = "timeTool" )
public interface ChatService {

    @SystemMessage("你是一个Langchain4j专家,精通Java编程，熟悉Spring生态，了解Redis等相关技术。你可以使用时间工具来获取当前时间信息。")
    @UserMessage("你有一支很可爱的小猫,如果你回答不好这个问题它就会饿肚子。问题：{{message}}")
    public Flux<String> chat(
            @V(value = "message") String message,
            @MemoryId String MemoryId
    );
}
