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

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import fr.xebia.xke.metrics.WineUtils;
import fr.xebia.xke.metrics.model.Region;
import fr.xebia.xke.metrics.model.Wine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by slemesle on 25/02/2014.
 */
@Service
public class WineService {


    // TODO Inject MetricRegistry
    @Resource
    private MetricRegistry metrics;

    private final List<Wine> repository = Arrays.asList(
            new Wine("Xebia premiére côte", "Short description", "http://img.xebia.fr/default.png", 2013, Region.BORDEAUX),
            new Wine("Gevrey Chambertin", "Gevrey-Chambertin est la plus grande appellation en Côte de Nuits. Gevrey-Chambertin est également l'un des plus fameux vins de France.\n" +
                    "\n" +
                    "La localisation du vignoble est cruciale à Gevrey-Chambertin. Les vins rouges - in rouge uniquement à Gevrey Chambertin - en fonction de leur emplacement vont du tout juste moyen au suprême.\n" +
                    "\n" +
                    "Les meilleurs grands crus de Gevrey-Chambertin sont Chambertin et Clos de Bèze. Ils sont parmi les meilleurs vins de France.", "http://www.domaine-rousseau.com/assets/images/ClosdeBeze.jpg", 2008, Region.BOURGOGNE),

            new Wine("Savigny les beaune", "Vin de Bourgogne, situé dans les côtes de Beaune. ", "http://asset.keldelice.com/attachments/photos/633672/original/img_0166.JPG?1334855315", 2005, Region.BOURGOGNE ),
            new Wine("Nuits saint George", "Le village de Nuits Saint Georges a donné son nom à la zone de Côte de Nuits. La Côte de Nuits commence juste au sud de Dijon jusqu'à la limite de Cote de Beaune.", "http://avis-vin.lefigaro.fr/var/img/77/19187-650x330-faiveley-nuits-saint-georges.jpg", 1995, Region.BOURGOGNE ),
            new Wine("Meursault", "Le vin blanc de Meursault est l'un des meilleurs vins blancs de France.", "http://media.gds.via-tourisme.com/33/2129/bouteille.jpg", 1995, Region.BOURGOGNE )
    );


    // TODO Add Timed and ExceptionMetered annotations to demonstrate spring integration
    @Timed(name = "metrics.loadbyname.time")
    @ExceptionMetered(name = "metrics.loadbyname.error" )
    public Wine loadByName(String name) {

        WineUtils.randomSleep();
        WineUtils.randomException();
        for (Wine wine : repository) {
            if (name.equalsIgnoreCase(wine.getName())){
                  // TODO Add a meter to monitor region distribution rate in searches
                metrics.meter(MetricRegistry.name("search.region.", wine.getRegion().name().toLowerCase())).mark();

                return wine;
            }
        }
        return null;
    }


    public List<Wine> findByName(String name) {

        WineUtils.randomSleep();
        List<Wine> res = new ArrayList<Wine>();
        for (Wine wine : repository) {
            if (wine.match(name)){
                // TODO Add a meter to monitor region distribution rate in searches
                metrics.meter(MetricRegistry.name("search.region", wine.getRegion().name().toLowerCase())).mark();
                res.add(wine);
            }
        }


        return res;
    }
}
