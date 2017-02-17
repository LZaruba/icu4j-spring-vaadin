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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Map-based arguments implementation. Used with patterns which have named arguments
 */
public class ICUMapMessageArguments implements ICUMessageArguments {

    Map<String, Object> args;

    public ICUMapMessageArguments(Map<String, Object> args) {
        if (args == null) args = Collections.emptyMap();
        this.args = args;
    }

    @Override
    public boolean isEmpty() {
        return args.isEmpty();
    }

    @Override
    public ICUMapMessageArguments transform(Transformation transformation) {
        Map<String, Object> newArgs = new LinkedHashMap<String, Object>(args.size());
        for (Map.Entry<String, Object> item: args.entrySet())
            newArgs.put(item.getKey(), transformation.transform(item.getValue()));
        return new ICUMapMessageArguments(newArgs);
    }

    @Override
    public String formatWith(MessageFormat messageFormat) {
        return messageFormat.format(args);
    }
}
