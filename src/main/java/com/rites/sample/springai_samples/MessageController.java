package com.rites.sample.springai_samples;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final SimplePromptSamples simplePromptSamples;

    @GetMapping("/ai")
    public String getMessage(@RequestBody String userInput) {

        simplePromptSamples.simplePrompt(userInput);
        return "llmResponse";
    }
}
