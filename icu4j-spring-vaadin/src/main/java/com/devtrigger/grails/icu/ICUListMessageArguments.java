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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Default, List-based arguments implementation. Used with patterns which have numbered arguments
 */
public class ICUListMessageArguments implements ICUMessageArguments {

    private List<Object> args;

    public ICUListMessageArguments(List<Object> args) {
        if (args == null) args = Collections.emptyList();
        this.args = args;
    }

    public ICUListMessageArguments(Object[] args) {
        if (args == null) args = new Object[0];
        this.args = Arrays.asList(args);
    }

    @Override
    public boolean isEmpty() {
        return args.isEmpty();
    }

    @Override
    public ICUListMessageArguments transform(Transformation transformation) {
        List<Object> newArgs = new ArrayList<Object>(args.size());
        for (Object item : args)
            newArgs.add(transformation.transform(item));
        return new ICUListMessageArguments(newArgs);
    }

    @Override
    public String formatWith(MessageFormat messageFormat) {
        return messageFormat.format(toArray());
    }

    public Object[] toArray() {
        return args.toArray(new Object[args.size()]);
    }
}
