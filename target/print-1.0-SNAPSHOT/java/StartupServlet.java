import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by brian on 7/15/15.
 */
@WebServlet(name = "StartupServlet")
public class StartupServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("configuration.ini");
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
    }
}
