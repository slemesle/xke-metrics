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
package fr.xebia.xke.metrics.health;

import fr.xebia.xke.metrics.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * TODO  Exercise 10 - extend HealtCheck  and implement missing method, using  DatabaseService#ping() method.
 *
 * Created by slemesle on 02/03/2014.
 */
@Component
public class DbHealthCheck  {

    private final DatabaseService dbService;

    // TODO Exercise 10 - Add the HealthCheckRegistry as dependency to register against it
     @Autowired
    public DbHealthCheck(DatabaseService dbService) {

        this.dbService = dbService;
    }

}
