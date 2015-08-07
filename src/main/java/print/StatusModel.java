package print;

import context.BeanLoader;
import org.auraframework.system.Annotations;
import replicatorg.app.Printer;

/**
 * Created by brian on 7/31/15.
 */
@Annotations.Model
public class StatusModel {
    private Printer printer;

    public StatusModel() {
        this.printer = BeanLoader.get().get(Printer.class);
    }

    @Annotations.AuraEnabled
    public boolean isPrinting() {
        return true;
//        return printer.isPrinting();
    }

    @Annotations.AuraEnabled
    public int getProgress() {
        return 55;
//        return printer.getProgress();
    }

    @Annotations.AuraEnabled
    public String getStatus() {
        return "terst";
//        return printer.getStatus();
    }
}
