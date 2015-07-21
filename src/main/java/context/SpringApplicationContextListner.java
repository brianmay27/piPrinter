package context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by brian on 7/19/15.
 */
public class SpringApplicationContextListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //BeanLoader.get();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
