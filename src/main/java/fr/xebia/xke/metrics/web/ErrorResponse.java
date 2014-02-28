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

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by slemesle on 28/02/2014.
 */
public class ErrorResponse {

    private final String message;
    private final String stack;

    public ErrorResponse(Exception e) {
        message = e.getMessage();
        StringWriter writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer));
        stack = writer.toString();
    }

    public String getMessage() {
        return message;
    }

    public String getStack() {
        return stack;
    }
}
