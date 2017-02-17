/**
 * Copyright (C) 2017 ZARFA s.r.o. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package cz.lzaruba.icu4j.spring.vaadin.demo;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import cz.lzaruba.icu4j.spring.vaadin.VaadinICUMessageSource;

/**
 * @author Lukas Zaruba, lukas.zaruba@zarfa.cz
 */
@SuppressWarnings("serial")
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
