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

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mockito;

import com.vaadin.server.VaadinSession;

/**
 * @author Lukas Zaruba, lukas.zaruba@gmail.com
 */
public class VaadinICUMessageSourceTest {
	
	@Test (expected = IllegalArgumentException.class)
	public void getNull1() throws Exception {
		new VaadinICUMessageSource().get(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getNull2() throws Exception {
		new VaadinICUMessageSource().get(null, Collections.emptyList());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getNull3() throws Exception {
		new VaadinICUMessageSource().get(null, "aaa");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getEmpty1() throws Exception {
		new VaadinICUMessageSource().get("");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getEmpty2() throws Exception {
		new VaadinICUMessageSource().get("", Collections.emptyList());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getEmpty3() throws Exception {
		new VaadinICUMessageSource().get("", "aaa");
	}
	
	@Test
	public void get() throws Exception {
		String result = new VaadinICUMessageSource() {
			
			@Override
			public String getMessage(String code, Object[] args, Locale locale) {
				assertEquals("test", code);
				assertEquals(Locale.UK, locale);
				assertEquals(0, args.length);
				return "test1";
			}
			
			protected Locale getCurrentLocale() {
				return Locale.UK;
			};
			
		}.get("test");
		assertEquals("test1", result);
	}
	
	@Test
	public void getArgs() throws Exception {
		String result = new VaadinICUMessageSource() {
			
			@Override
			public String getMessage(String code, Object[] args, Locale locale) {
				assertEquals("test", code);
				assertEquals(Locale.UK, locale);
				assertEquals(2, args.length);
				assertEquals("aaa", args[0]);
				assertEquals("bbb", args[1]);
				return "test1";
			}
			
			protected Locale getCurrentLocale() {
				return Locale.UK;
			};
			
		}.get("test", "aaa", "bbb");
		assertEquals("test1", result);
	}
	
	@Test
	public void getList() throws Exception {
		String result = new VaadinICUMessageSource() {
			
			@Override
			public String getMessage(String code, Object[] args, Locale locale) {
				assertEquals("test", code);
				assertEquals(Locale.UK, locale);
				assertEquals(2, args.length);
				assertEquals("aaa", args[0]);
				assertEquals("bbb", args[1]);
				return "test1";
			}
			
			protected Locale getCurrentLocale() {
				return Locale.UK;
			};
			
		}.get("test", Arrays.asList("aaa", "bbb"));
		assertEquals("test1", result);
	}
	
	@Test
	public void getMap() throws Exception {
		Map<String, Object> values = new HashMap<>();
		values.put("key1", "value1");
		values.put("key2", "value2");
		String result = new VaadinICUMessageSource() {
			
			@Override
			public String getMessage(String code, Map<String, Object> args, Locale locale) {
				assertEquals("test", code);
				assertEquals(Locale.UK, locale);
				assertEquals(2, args.size());
				assertEquals("value1", values.get("key1"));
				assertEquals("value2", values.get("key2"));
				return "test1";
			}
			
			protected Locale getCurrentLocale() {
				return Locale.UK;
			};
			
		}.get("test", values);
		assertEquals("test1", result);
	}
	
	@Test
	public void vaadinLocale() throws Exception {
		Locale l = new Locale("cs_CZ");
		VaadinSession s = Mockito.mock(VaadinSession.class);
		Mockito.when(s.getLocale()).thenReturn(l);
		VaadinSession.setCurrent(s);
		try {
			assertEquals("vaadin", new VaadinICUMessageSource() {
				
				public String getMessage(String code, Object[] args, Locale locale) {
					assertEquals(l, locale);
					return "vaadin";
				}
				
			}.get("key"));
		} finally {
			VaadinSession.setCurrent(null);
		}
		
	}
	
}
