package cz.lzaruba.icu4j.spring.vaadin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cz.lzaruba.icu4j.spring.vaadin.VaadinICUMessageSource;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public VaadinICUMessageSource getUIMessages() {
		VaadinICUMessageSource messageSource = new VaadinICUMessageSource();
	    messageSource.setBasename("classpath:uiMessages");
	    messageSource.setCacheSeconds(3600);
	    messageSource.setFallbackToSystemLocale(false);
	    return messageSource;
	}
}
