package authentication;

import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.auraframework.Aura;
import org.auraframework.system.AuraContext;

import javax.servlet.ServletContextEvent;

/**
 * Created by brian on 7/19/15.
 */
public class CustomEnvironmentLoaderListener extends EnvironmentLoaderListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
        Aura.getContextService().startContext(AuraContext.Mode.PROD, AuraContext.Format.JSON, AuraContext.Authentication.AUTHENTICATED);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Aura.getContextService().endContext();
        super.contextDestroyed(sce);
    }
}
