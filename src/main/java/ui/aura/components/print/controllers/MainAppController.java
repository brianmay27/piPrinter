package ui.aura.components.print.controllers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.auraframework.system.Annotations;

/**
 * Created by brian on 7/15/15.
 */
@Annotations.Model
public class MainAppController {

    @Annotations.AuraEnabled
    public Boolean getIsAdmin() {
        Subject user = SecurityUtils.getSubject();
        return user.hasRole("Administrator");
    }
}
