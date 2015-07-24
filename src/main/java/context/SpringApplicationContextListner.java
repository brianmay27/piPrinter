package context;

import configuration.Configuration;
import gnu.io.CommPortIdentifier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by brian on 7/19/15.
 */
public class SpringApplicationContextListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        new File(Configuration.UPLOADS).mkdirs();
        Properties props = new Properties();
        try {
            props.load(getClass().getClassLoader().getResourceAsStream("print.properties"));
            for (String prop : props.stringPropertyNames()) {
                System.setProperty(prop, props.getProperty(prop));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();
        if (ports != null) {
            while (ports.hasMoreElements()) {
                System.out.println(ports.nextElement().getName());
            }
        }

        //BeanLoader.get();
        System.out.println("Ports: " + System.getProperties().getProperty("gnu.io.rxtx.SerialPorts"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
