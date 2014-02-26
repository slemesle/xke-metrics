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

import fr.xebia.xke.metrics.model.Wine;
import fr.xebia.xke.metrics.service.WineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by slemesle on 25/02/2014.
 */
@Controller
@RequestMapping("/rest/*")
public class WineController {

    @Resource
    WineService wineService;


    @RequestMapping(value = "/wine/{name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Wine> findByName(@PathVariable String name){

        Wine result = wineService.findByName(name);

        return new ResponseEntity<Wine>(result, HttpStatus.OK);
    }

}
