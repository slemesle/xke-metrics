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

import com.google.common.base.Function;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import fr.xebia.xke.metrics.model.Wine;
import fr.xebia.xke.metrics.service.OrderService;
import fr.xebia.xke.metrics.service.WineService;
import fr.xebia.xke.metrics.model.OrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by slemesle on 25/02/2014.
 */
@Controller
@RequestMapping("/rest/*")
public class WineController {

    private static final Logger log = LoggerFactory.getLogger(WineController.class);
/*
    private final Timer cachedSearchTimer;
    private final Timer directSearchTimer;
    private final MetricRegistry metricRegistry;
*/

    @Resource
    private WineService wineService;

    @Resource
    private OrderService orderService;



    final LoadingCache<String, List<Wine>> searchCache;

    // TODO inject Metrics Registry
    //@Autowired
    public WineController(/*MetricRegistry metricRegistry*/) {
//        this.metricRegistry = metricRegistry;
        searchCache = CacheBuilder.newBuilder().maximumSize(200)
                .expireAfterAccess(2, TimeUnit.MINUTES).recordStats()
                .build(CacheLoader.from(new Function<String, List<Wine>>() {
                    @Override
                    public List<Wine> apply(String _name) {
                        return wineService.findByName(_name);
                    }
                }));


        //TODO add two timers to monitor find service response time in cached and direct mode
        //cachedSearchTimer = metricRegistry.timer("find.cached");
        //directSearchTimer = metricRegistry.timer("find.direct");
    }

    @PostConstruct
    public void doPostInit(){
/*
        // TODO Add a gauge to registry for cache size
        metricRegistry.register(MetricRegistry.name(WineController.class, "search", "cache", "size"), new Gauge<Long>() {
            @Override
            public Long getValue() {
                return searchCache.size();
            }
        });
        // TODO Add a gauge to registry for cache hits
        metricRegistry.register(MetricRegistry.name(WineController.class, "search", "cache", "hits"), new Gauge<Long>() {
            @Override
            public Long getValue() {
                return searchCache.stats().hitCount();
            }
        });
        // TODO Add a gauge to registry for cache miss
        metricRegistry.register(MetricRegistry.name(WineController.class, "search", "cache", "miss"), new Gauge<Long>() {
            @Override
            public Long getValue() {
                return searchCache.stats().missCount();
            }
        });        // TODO Add a gauge to registry for cache hit ratio
        metricRegistry.register(MetricRegistry.name(WineController.class, "search", "cache", "miss"), new RatioGauge() {
            @Override
            protected Ratio getRatio() {
                return Ratio.of(searchCache.stats().hitCount(), searchCache.stats().requestCount());
            }

        });
*/

        // TODO Register new created MetricSet
     //   metricRegistry.registerAll(new GuavaCacheMetricsSet(searchCache, MetricRegistry.name(WineController.class, "search", "cache" ) ));
    }

    @RequestMapping(value = "/wine/{name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Wine> loadByName(@PathVariable String name) {

        Wine result = wineService.loadByName(name);

        return new ResponseEntity<Wine>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/wine/search/{name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Wine>> findByName(@PathVariable String name) {

       // Timer.Context time = directSearchTimer.time();

        try {
            List<Wine> result = wineService.findByName(name);

            return new ResponseEntity<List<Wine>>(result, HttpStatus.OK);
        } finally {
         //   time.stop();
        }
    }

    @RequestMapping(value = "/cached/wine/search/{name}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Wine>> findCachedByName(@PathVariable String name) {
        //Timer.Context time = cachedSearchTimer.time();

        try {
            List<Wine> result = null;
            try {
                result = searchCache.get(name);
                log.info(searchCache.stats().toString());
                return new ResponseEntity<List<Wine>>(result, HttpStatus.OK);
            } catch (ExecutionException e) {
                log.error("Failed to access data in cache", e);
            }
            return new ResponseEntity<List<Wine>>(new ArrayList<Wine>(), HttpStatus.NO_CONTENT);
        } finally {
       //     time.stop();
        }
    }

    @RequestMapping(value = "/wine/{name}/buy", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<OrderResponse> placeWineOrder(@PathVariable String name){

        return new ResponseEntity<OrderResponse>(orderService.placeOrder(wineService.loadByName(name)), HttpStatus.NO_CONTENT);
    }


    /**
     * TODO Add a meter to monitor error rate
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e){

    //    metricRegistry.meter("wine.controler.exception").mark();
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(e), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
