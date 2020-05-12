package dev.trials.spring.services.eventdispatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties(value = {ApiMetadata.class})
public class DomainEvtDispatchApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DomainEvtDispatchApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DomainEvtDispatchApplication.class);
    }
}
