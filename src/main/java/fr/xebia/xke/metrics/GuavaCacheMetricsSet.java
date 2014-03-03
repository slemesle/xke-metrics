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
 *//*

package fr.xebia.xke.metrics;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.MetricSet;
import com.google.common.cache.Cache;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

*/
/**
 *
 * TODO Implement the MetricSet contract to expose GuavaCache stats
 *
 * Created by slemesle on 27/02/2014.
 *//*

public class GuavaCacheMetricsSet implements MetricSet {

    private final Cache<?, ?> cache;
    private final String namePrefix;

    public GuavaCacheMetricsSet(Cache<?,?> _cache, String namePrefix) {

        this.cache = _cache;
        this.namePrefix = namePrefix;
    }

    @Override
    public Map<String, Metric> getMetrics() {

        Map<String, Metric> result = new LinkedHashMap<String, Metric>();

        result.put(MetricRegistry.name(namePrefix, "eviction"), new Gauge<Long>() {
            @Override
            public Long getValue() {
                return cache.stats().evictionCount();
            }
        });
        result.put(MetricRegistry.name(namePrefix, "hits"), new Gauge<Long>() {
            @Override
            public Long getValue() {
                return cache.stats().hitCount();
            }
        });
        result.put(MetricRegistry.name(namePrefix, "miss"), new Gauge<Long>() {
            @Override
            public Long getValue() {
                return cache.stats().missCount();
            }
        });
        result.put(MetricRegistry.name(namePrefix, "load"), new Gauge<Long>() {
            @Override
            public Long getValue() {
                return cache.stats().loadCount();
            }
        });
        result.put(MetricRegistry.name(namePrefix, "load-exception"), new Gauge<Long>() {
            @Override
            public Long getValue() {
                return cache.stats().loadExceptionCount();
            }
        });
        result.put(MetricRegistry.name(namePrefix, "load-success"), new Gauge<Long>() {
            @Override
            public Long getValue() {
                return cache.stats().loadSuccessCount();
            }
        });
        result.put(MetricRegistry.name(namePrefix, "request"), new Gauge<Long>() {
            @Override
            public Long getValue() {
                return cache.stats().requestCount();
            }
        });
        result.put(MetricRegistry.name(namePrefix, "load-time"), new Gauge<Long>() {
            @Override
            public Long getValue() {
                return cache.stats().totalLoadTime();
            }
        });
        result.put(MetricRegistry.name(namePrefix, "load-penalty"), new Gauge<Double>() {
            @Override
            public Double getValue() {
                return cache.stats().averageLoadPenalty();
            }
        });
        result.put(MetricRegistry.name(namePrefix, "hit-rate"), new Gauge<Double>() {
            @Override
            public Double getValue() {
                return cache.stats().hitRate();
            }
        });
        result.put(MetricRegistry.name(namePrefix, "miss-rate"), new Gauge<Double>() {
            @Override
            public Double getValue() {
                return cache.stats().missRate();
            }
        });
        result.put(MetricRegistry.name(namePrefix, "size"), new Gauge<Long>() {
            @Override
            public Long getValue() {
                return cache.size();
            }
        });

        return Collections.unmodifiableMap(result);
    }
}
*/
