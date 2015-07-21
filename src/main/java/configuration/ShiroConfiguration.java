package configuration;

import org.apache.shiro.mgt.*;
import org.apache.shiro.web.env.WebEnvironment;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by brian on 7/14/15.
 */
public class ShiroConfiguration implements WebEnvironment {
    @Override
    public FilterChainResolver getFilterChainResolver() {
        return new FilterChainResolver() {
            @Override
            public FilterChain getChain(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
                return null;
            }
        };
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public WebSecurityManager getWebSecurityManager() {
        return null;
    }

    @Override
    public org.apache.shiro.mgt.SecurityManager getSecurityManager() {
        return null;
    }
}
