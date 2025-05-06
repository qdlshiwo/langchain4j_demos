package com.kizzo.langchain4j_demos;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TestChat {
    @Test
     void testChat(){
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        String answer = model.chat("Say 'Hello World'");
        System.out.println(answer); // Hello World
        String answer2 = model.chat("你好你是谁？");
        System.out.println(answer2);
    }

    @Test
     void testDeepseekChat(){
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("https://api.deepseek.com")
                .apiKey(ApiKeys.DEEPSEEK_API_KEY)
                .modelName("deepseek-chat")
                .build();
        String answer = model.chat("你好你是谁？");
        System.out.println(answer);
    }

    @Test
    void testQwenChat(){
        QwenChatModel model = QwenChatModel.builder()
                .apiKey(ApiKeys.QWEN_API_KEY)
                .modelName("qwen-plus")
                .build();
        String answer = model.chat("你好你是谁？");
        System.out.println(answer);
    }
    @Test
     void testOllamaChat() {
        ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("deepseek-r1:1.5b")
                .build();
        String answer = model.chat("你好你是谁？");
        log.info(answer);
    }
    @Test
    void testWangxiangChat(){
        WanxImageModel model = WanxImageModel.builder()
                .apiKey(ApiKeys.QWEN_API_KEY)
                .modelName("wanx2.1-t2i-turbo")
                .build();
        Response<Image> response = model.generate("守望先锋");
        System.out.println(response.content().url());
    }


}
