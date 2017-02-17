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

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import cz.lzaruba.icu4j.spring.vaadin.VaadinICUMessageSource;

/**
 * @author Lukas Zaruba, lukas.zaruba@gmail.com
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
