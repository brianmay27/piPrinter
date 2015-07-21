import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;

/**
 * Created by brian on 7/15/15.
 */
public class StartupServlet {

    public static void main(String[] args) {
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("WEB-INF/shiro.ini");
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
    }
}
