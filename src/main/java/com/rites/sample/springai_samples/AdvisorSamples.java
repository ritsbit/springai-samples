package com.rites.sample.springai_samples;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdvisorSamples {

    private final ChatClient openAiChatClient;

    public void test() {

    }
}
