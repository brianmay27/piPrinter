package print;

import context.BeanLoader;
import org.auraframework.system.Annotations;
import replicatorg.app.Printer;

/**
 * Created by brian on 7/31/15.
 */
@Annotations.Controller
public class StatusController {

    @Annotations.AuraEnabled
    public static String getStatus() {
        Printer printer = BeanLoader.get().get(Printer.class);
        return printer.getStatus();
    }

    public boolean shouldUpdate() {
        return false;
    }
}
