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


import fr.xebia.xke.metrics.WineUtils;
import fr.xebia.xke.metrics.model.OrderResponse;
import fr.xebia.xke.metrics.model.Wine;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 *
 * This class simulate an order service using a third party remote service.
 *
 * TODO Exercise 7 - add a counter to maintain the exact running placeOrder service First inject the registry,
 * then increment and decrement the counter.
 */
@Service
public class OrderService {


    public OrderResponse placeOrder(Wine wine){

        // TODO Exercise 7 - increment 'order.running.count'

        try {
            WineUtils.randomException();

            OrderResponse response = new OrderResponse(wine, UUID.randomUUID().toString(), "http://verify.payment.com");
            WineUtils.randomSleep();
            return response;
        } finally {
       //  TODO Exercise 7 -   decrement here
        }

    }

    public boolean pingPaypal() {

        WineUtils.randomSleep();
        WineUtils.randomException("Paypal unavailable");
        return WineUtils.randomBoolean();
    }
}
