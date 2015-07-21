package authentication;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by brian on 7/18/15.
 */
public class CustomAuthenticationListener implements AuthenticationListener {
    @Override
    public void onSuccess(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {

    }

    @Override
    public void onFailure(AuthenticationToken authenticationToken, AuthenticationException e) {

    }

    @Override
    public void onLogout(PrincipalCollection principalCollection) {

    }
}
