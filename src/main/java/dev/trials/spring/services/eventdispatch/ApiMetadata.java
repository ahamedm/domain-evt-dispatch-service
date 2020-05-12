package dev.trials.spring.services.eventdispatch;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties(prefix = "apimeta")
@Data
@NoArgsConstructor
public class ApiMetadata {

	private String version;
	private String desc;

}