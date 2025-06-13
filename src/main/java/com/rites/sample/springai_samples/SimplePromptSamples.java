package com.rites.sample.springai_samples;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SimplePromptSamples {

    private final ChatClient openAiChatClient;
    private final ChatClient parameterisedChatClient;

    public String simplePrompt(String userInput) {
        return openAiChatClient
                .prompt(userInput)
                .call()
                .content();
    }

    public ActorFilms responseConversion(String userInput) {
        // Example of response conversion to a custom class
        return openAiChatClient.prompt()
                .user(userInput)
                .call()
                .entity(ActorFilms.class);
    }

    public List<ActorFilms> parameterisedTypeResponseConversion(String userInput) {
        return openAiChatClient.prompt()
                .user(userInput)
                .call()
                .entity(new ParameterizedTypeReference<List<ActorFilms>>() {});
    }

    public ChatClientResponse promptTemplateExample(String userInput, String composer) {
        // Example of using a prompt template with parameters
        return openAiChatClient.prompt()
                .user(u -> u
                        .text(userInput)
                        .param("composer", composer))
                .call()
                .chatClientResponse();
    }

    public String parameterisedPrompt(String userInput) {
        return parameterisedChatClient.prompt()
                .system(sp -> sp.param("voice", "pirate"))
                .user(userInput)
                .call()
                .content();
    }

    public record ActorFilms(String actor, List<String> movies) {}
}
