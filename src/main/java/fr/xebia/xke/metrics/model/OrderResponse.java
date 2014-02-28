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
package fr.xebia.xke.metrics.model;


/**
 * Created by slemesle on 28/02/2014.
 */
public class OrderResponse {

    private final Wine wine;
    private final String token;
    private final String url;

    public OrderResponse(Wine wine, String token, String url) {

        this.wine = wine;
        this.token = token;
        this.url = url;
    }


    public Wine getWine() {
        return wine;
    }

    public String getToken() {
        return token;
    }

    public String getUrl() {
        return url;
    }
}
