/*
 * Copyright 2013  Séven Le Mesle
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package fr.xebia.xke.metrics;

import com.google.common.cache.Cache;


/**
 *
 *  TODO Exercise 6 -  Implement the MetricSet interface and expose GuavaCache stats
 *
 */
public class GuavaCacheMetricsSet {

    private final Cache<?, ?> cache;
    private final String namePrefix;

    public GuavaCacheMetricsSet(Cache<?,?> _cache, String namePrefix) {

        this.cache = _cache;
        this.namePrefix = namePrefix;
    }

}
