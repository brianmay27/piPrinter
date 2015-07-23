package context;

import configuration.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

/**
 * Created by brian on 7/19/15.
 */
public class SpringApplicationContextListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        new File(Configuration.UPLOADS).mkdirs();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
