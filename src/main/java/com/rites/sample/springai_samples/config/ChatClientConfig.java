package com.rites.sample.springai_samples.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

@Configurable
public class ChatClientConfig {

    @Bean
    public ChatClient openAiChatClient(OpenAiChatModel chatModel) {
        return ChatClient
                .builder(chatModel)
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }

    @Bean
    public ChatClient.Builder openAiChatClientBuilder(OpenAiChatModel chatModel) {
        return ChatClient
                .builder(chatModel)
                .defaultAdvisors(new SimpleLoggerAdvisor());
    }

    @Bean
    public ChatClient parameterisedChatClient(@Qualifier("openAiChatClientBuilder") ChatClient.Builder builder) {
        return builder
                .defaultSystem("You are a friendly chat bot that answers question in the voice of a {voice}")
                .build();
    }
}
