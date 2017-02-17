/**
 * Copyright (C) the original author or authors.
 * Copied from https://github.com/meticoeus/spring-icu
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
package com.devtrigger.grails.icu;

import com.ibm.icu.text.MessageFormat;

/**
 * Describes common behaviour of message arguments, both list- and map-based
 */
public interface ICUMessageArguments {

    ICUMessageArguments transform(Transformation transformation);

    boolean isEmpty();

    String formatWith(MessageFormat messageFormat);

    interface Transformation {
        Object transform(Object item);
    }
}
