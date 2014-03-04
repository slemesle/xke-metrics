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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * TODO Exercise 11 - Implement a custom healthcheck controller
 * Inject the Registry, run health checks then iterate over the result to return a string of the form :
 *
 * name:[OK/KO (description)]|name:[OK/KO (description)]|...
 *
 * Response code should be 200 OK when healthy and 412 PRECONDITION FAILED when not healthy.
 */
@Controller("/admin/*")
public class HealthCheckController {


    @RequestMapping(value = "healthcheck", method = RequestMethod.GET, produces = "text/plain")
    public ResponseEntity<String> runChecks(){

        boolean healthy = true;
        StringBuilder sb = new StringBuilder();

        // TODO Exercise 11 - run checks here and build response String

        return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
    }


}
