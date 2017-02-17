/**
 * Copyright (C) 2017 Lukas Zaruba, lukas.zaruba@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cz.lzaruba.icu4j.spring.vaadin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cz.lzaruba.icu4j.spring.vaadin.VaadinICUMessageSource;

/**
 * @author Lukas Zaruba, lukas.zaruba@gmail.com
 */
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
