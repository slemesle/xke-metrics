package fr.xebia.xke.metrics.web;
/**
 * Created by slemesle on 26/02/2014.
 */


import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

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

/* TODO Add Registries to servlet context
        sce.getServletContext().setAttribute(MetricsServlet.METRICS_REGISTRY, context.getBean(MetricRegistry.class));
        sce.getServletContext().setAttribute(InstrumentedFilter.REGISTRY_ATTRIBUTE, context.getBean(MetricRegistry.class));
        sce.getServletContext().setAttribute(HealthCheckServlet.HEALTH_CHECK_REGISTRY, context.getBean(HealthCheckRegistry.class));
*/
    }
}
