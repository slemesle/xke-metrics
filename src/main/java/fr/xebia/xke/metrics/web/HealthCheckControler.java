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
package fr.xebia.xke.metrics.web;

import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheckRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Map;
import java.util.SortedMap;

/**
 * TODO Implement a custom healthceck controller
 * Created by slemesle on 02/03/2014.
 */
@Controller("/admin/*")
public class HealthCheckControler {

    @Resource
    HealthCheckRegistry registry;

    @RequestMapping(value = "healthcheck", method = RequestMethod.GET, produces = "text/plain")
    public ResponseEntity<String> runChecks(){

        boolean healthy = true;
        StringBuilder sb = new StringBuilder();
        SortedMap<String,HealthCheck.Result> checks = registry.runHealthChecks();
        for (Map.Entry<String, HealthCheck.Result> entry : checks.entrySet()) {
            sb.append(entry.getKey()).append(":");
            if (!entry.getValue().isHealthy()){
                healthy = false;
                sb.append("KO").append(" (").append(entry.getValue().getMessage()).append(")");
            } else {
                sb.append("OK");
            }
            sb.append('|');
        }
        sb.deleteCharAt(sb.length() -1);

        return new ResponseEntity<String>(sb.toString(),  healthy ? HttpStatus.OK : HttpStatus.PRECONDITION_FAILED);
    }


}
