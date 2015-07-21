package authentication;

import org.auraframework.http.AuraContextFilter;
import org.auraframework.system.AuraContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by brian on 7/20/15.
 */
public class CustomAuraContextFilter extends AuraContextFilter {
    @Override
    protected AuraContext startContext(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        return super.startContext(req, res, chain);
    }
}
