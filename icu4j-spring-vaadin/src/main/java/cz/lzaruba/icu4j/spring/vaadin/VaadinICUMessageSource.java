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
package cz.lzaruba.icu4j.spring.vaadin;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.MessageSource;

import com.devtrigger.grails.icu.ICUMessageSource;
import com.devtrigger.grails.icu.ICUReloadableResourceBundleMessageSource;
import com.vaadin.server.VaadinSession;

/**
 * Message source that supports ICU4J message formatting and can easily 
 * be used as a Spring bean instead of standard {@link MessageSource}.
 * 
 * This message source provides variants of getMessage methods without locale parameter named get(...).
 * The locale is loaded from the current VaadinSession.
 * 
 * @author Lukas Zaruba, lukas.zaruba@gmail.com
 */
public class VaadinICUMessageSource extends ICUReloadableResourceBundleMessageSource {
	
	/**
	 * @return message for given key and current VaadinSession locale.
	 * Equivalent to {@link ICUMessageSource#getMessage(String, Object[], Locale)}.
	 * @throws IllegalStateException if there is no Vaadin Session in the context.
	 */
	public String get(String key, Object ... params) {
		if (key == null || key.isEmpty()) {
			throw new IllegalArgumentException("Key must be filled!");
		}
		return getMessage(key, params, getCurrentLocale());
	}
	
	/**
	 * @return message for given key and current VaadinSession locale.
	 * Equivalent to {@link ICUMessageSource#getMessage(String, Object[], Locale)} with empty second param.
	 * @throws IllegalStateException if there is no Vaadin Session in the context.
	 */
	public String get(String key) {
		return get(key, new Object[0]);
	}
	
	/**
	 * @see #getMessage(String, Object...)
	 */
	public String get(String key, List<Object> params) {
		return get(key, params.toArray());
	}
	
	/**
	 * @return message for given key and current VaadinSession locale.
	 * Equivalent to {@link ICUMessageSource#getMessage(String, Map, Locale)}.
	 * @throws IllegalStateException if there is no Vaadin Session in the context.
	 */
	public String get(String key, Map<String, Object> params) {
		return getMessage(key, params, getCurrentLocale());
	}
	
	protected Locale getCurrentLocale() {
		return VaadinSession.getCurrent().getLocale();
	}

}
