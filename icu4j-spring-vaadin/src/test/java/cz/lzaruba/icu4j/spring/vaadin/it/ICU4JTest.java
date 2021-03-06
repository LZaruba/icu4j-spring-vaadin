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
package cz.lzaruba.icu4j.spring.vaadin.it;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author Lukas Zaruba, lukas.zaruba@gmail.com
 */
@ContextConfiguration(classes = {ICU4JConfig.class})
public class ICU4JTest extends AbstractMessagesTest {
	
	@Autowired
	private MessageSource icu4jMessages;
	
	protected void exec(String expected, String key, String locale, Object ... params) {
		assertEquals(expected, icu4jMessages.getMessage(key, params, new Locale(locale)));
	}

}
