package com.rites.sample.springai_samples;

import com.rites.sample.springai_samples.config.ChatClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ChatClientConfig.class)
public class SpringaiSamplesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringaiSamplesApplication.class, args);
	}

}
