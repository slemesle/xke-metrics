/**
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

import fr.xebia.xke.metrics.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * TODO Exercise 10 - Extend HealthCheck, implement the missing method using OrderSerivce#pingPaypal() and register OrderHealthCheck against registry
 * Created by slemesle on 02/03/2014.
*/
@Component
public class OrderHealthCheck {

    private final OrderService orderService;

    @Autowired
    public OrderHealthCheck(OrderService orderService) {
        this.orderService = orderService;
    }

}
