package print;

import context.BeanLoader;
import org.auraframework.system.Annotations;
import replicatorg.app.Printer;

/**
 * Created by brian on 7/22/15.
 */
@Annotations.Controller
public class AdminController {

    @Annotations.AuraEnabled
    public static void print(@Annotations.Key("file") String file) {
        Printer printer = BeanLoader.get().get(Printer.class);
        //printer.Print(file);
    }

}
