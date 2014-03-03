package fr.xebia.xke.metrics.web;
/**
 * Created by slemesle on 26/02/2014.
 */


import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;

/**
 *
 * Utility ContextLoaderListener for Spring and metrics.
 * This makes possible to use AdminServlet with Spring provided Registries.
 */
public class MetricsAdminContextLoader extends ContextLoaderListener {

    public MetricsAdminContextLoader() {}

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);

        WebApplicationContext context = (WebApplicationContext) sce.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

/* TODO Exercise 2 - Add Registries to servlet context as attribute
    MetricsServlet.METRICS_REGISTRY             -> MetricRegistry.class
    InstrumentedFilter.REGISTRY_ATTRIBUTE       -> MetricRegistry.class
    HealthCheckServlet.HEALTH_CHECK_REGISTRY    -> HealthCheckRegistry.class
*/
    }
}
