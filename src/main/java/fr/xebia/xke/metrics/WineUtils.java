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
package fr.xebia.xke.metrics;

/**
 * Created by slemesle on 28/02/2014.
 */
public class WineUtils {


    public static final void randomSleep() {
        try { // Emulate a service load
            Thread.sleep((long) Math.abs(Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void randomException() {
        if ((long) Math.abs(Math.random()*1000) % 57 == 0 ){
            throw new RuntimeException("Random Exception Raised");
        }
    }

    public static void randomException(String s) {
        if ((long) Math.abs(Math.random()*1000) < 500){
            throw new RuntimeException(s);
        }
    }

    public static boolean randomBoolean() {
        return Math.abs(Math.random()*1000) % 57 != 0;
    }
}
