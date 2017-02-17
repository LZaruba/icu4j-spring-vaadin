# icu4j-spring-vaadin Add-on Project

Do you like all ICU4J, Vaadin and Spring?

Here is the Add-on that will allow you to connect these three elements right together!

This Add-on provides you with Spring MessageSource compatible wrapper of ICU4J messages provider that uses current VaadinSession to obtain the Locale.
 
## Usage
1. Define the Bean in your Application configuration
```Java
	@Bean(name = "uiMessages")
	public VaadinICUMessageSource getUIMessages() {
		VaadinICUMessageSource uiMessages = new VaadinICUMessageSource();
	    uiMessages.setBasename("classpath:uiMessages");
	    uiMessages.setCacheSeconds(3600);
	    uiMessages.setFallbackToSystemLocale(false);
	    return uiMessages;
	}
```

2. Use your Bean in your UI code
```Java
	@SpringUI
	public class MainUI extends UI {
		
		@Autowired
		private VaadinICUMessageSource uiMessages;
		
		private int counter = 0;
		
		@Override
		protected void init(VaadinRequest request) {
			setContent(new Button(uiMessages.get("label"), e -> {
				Notification.show(uiMessages.get("notification", counter));
				counter++;
			}));
		}
		
	}
```

## More resources
See the ```cz.lzaruba.icu4j.spring.vaadin.VaadinICUMessageSource``` source or JavaDoc for more details on available methods.
See the project of the [original ICU4J + Spring combination](https://github.com/meticoeus/spring-icu/)
See the [ICU4J syntax options](http://userguide.icu-project.org/formatparse/messages)
See the [Demo Application](https://github.com/LZaruba/icu4j-spring-vaadin/tree/master/cz.lzaruba.icu4j.spring.vaadin.demo) 

## Credits
This project is based on the code from https://github.com/meticoeus/spring-icu/. 
Credit to the original code is marked in the header of each file.

## License
This Add-on is licensed under the terms of the Apache License, Version 2.0.