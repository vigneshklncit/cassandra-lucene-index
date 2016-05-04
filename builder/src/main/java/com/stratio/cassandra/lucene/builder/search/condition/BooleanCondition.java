/*
 * Copyright (C) 2014 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stratio.cassandra.lucene.builder.search.condition;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A {@link Condition} that matches documents matching boolean combinations of other queries, e.g. {@link
 * MatchCondition}s, {@link RangeCondition}s or other {@link BooleanCondition}s.
 *
 * @author Andres de la Pena {@literal <adelapena@stratio.com>}
 */
public class BooleanCondition extends Condition {

    /** The mandatory conditions. */
    @JsonProperty("must")
    final List<Condition> must = new ArrayList<>();

    /** The optional conditions. */
    @JsonProperty("should")
    final List<Condition> should = new ArrayList<>();

    /** The mandatory not conditions. */
    @JsonProperty("not")
    final List<Condition> not = new ArrayList<>();

    /**
     * Returns this builder with the specified mandatory conditions.
     *
     * @param conditions The mandatory conditions to be added.
     * @return this builder with the specified mandatory conditions.
     */
    public BooleanCondition must(Condition... conditions) {
        must.addAll(Arrays.asList(conditions));
        return this;
    }

    /**
     * Returns this builder with the specified optional conditions.
     *
     * @param conditions The optional conditions to be added.
     * @return this builder with the specified optional conditions.
     */
    public BooleanCondition should(Condition... conditions) {
        should.addAll(Arrays.asList(conditions));
        return this;
    }

    /**
     * Returns this builder with the specified mandatory not conditions.
     *
     * @param conditions The mandatory not conditions to be added.
     * @return this builder with the specified mandatory not conditions.
     */
    public BooleanCondition not(Condition... conditions) {
        not.addAll(Arrays.asList(conditions));
        return this;
    }
}
