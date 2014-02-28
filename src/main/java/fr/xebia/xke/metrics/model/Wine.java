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
 * Created by slemesle on 25/02/2014.
 */
public class Wine {


    private final String name;
    private final String description;
    private final String img;
    private final int cru;
    private final Region region;


    public Wine(String name, String description, String img, int cru, Region region) {

        this.name = name;
        this.description = description;
        this.img = img;
        this.cru = cru;
        this.region = region;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }


    public int getCru() {
        return cru;
    }

    public Region getRegion() {
        return region;
    }

    public boolean match(String _name) {
        boolean res = true;
        if (!name.contains(_name)  && !description.contains(_name)){
            res = false;
        }
        return res;
    }
}
