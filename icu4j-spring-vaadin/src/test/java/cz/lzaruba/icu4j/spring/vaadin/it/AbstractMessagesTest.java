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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Lukas Zaruba, lukas.zaruba@gmail.com
 */
@RunWith(SpringRunner.class)
public abstract class AbstractMessagesTest {
	
	@Test
	public void simple() throws Exception {
		exec("simple_value", "simple", "en");
		exec("hodnota", "simple", "cs");
		exec("hodnota1", "simple", "cs_cz");
	}
	
	@Test
	public void plural() throws Exception {
		exec("1 car", "plural", "en", 1);
		exec("4 cars", "plural", "en", 4);
	}
	
	@Test
	public void pluralNonDefaultLocale() throws Exception {
		exec("1 auto", "plural", "cs", 1);
		exec("4 auta", "plural", "cs", 4);
	}
	
	@Test
	public void pluralNonDefaultLocaleComplex() throws Exception {
		exec("1 auto1", "plural", "cs_cz", 1);
		exec("4 auta1", "plural", "cs_cz", 4);
	}
	
	/**
	 * falls back to default bundle, not to pl bundle!
	 */
	@Test
	public void pluralNonDefaultLocaleFallback() throws Exception {
		exec("1 car", "plural", "pl_pl", 1);
		exec("4 cars", "plural", "pl_pl", 4);
	}

	protected abstract void exec(String expected, String key, String locale, Object ... params);

}
