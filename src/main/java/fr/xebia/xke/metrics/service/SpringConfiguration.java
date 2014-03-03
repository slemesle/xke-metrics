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
package fr.xebia.xke.metrics.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


/**
 * Created by slemesle on 26/02/2014.
 */
@Configuration
public class SpringConfiguration {


    /**
     * TODO Exercice 1 - 1 Build the MetricRegistry and return it. Also change the method Signature to return MetricRegistry
     * @return
     */
    @Bean(name = "metricRegistry") @Scope
    Object provideMetricsRegistry(){


        // TODO Exercise 3 - add default JVM Metrics
     /*

        JmxReporter reporter = JmxReporter.forRegistry(result).build();
        reporter.start();
*/
        // TODO add JMX reporter
        return null;
    }

    /**
     * TODO  Exercice 1 - 2 Build the HealthCheckRegistry and return it. Also change the method Signature to return HealthCheckRegistry
     * @return
     */
    @Bean(name = "healthCheckRegistry")
    Object provideHealthChecksRegistry(){
        return null;
    }

}
