package print;

import configuration.Settings;
import context.BeanLoader;
import org.auraframework.system.Annotations;
import replicatorg.machine.MachineFactory;

import java.util.List;

/**
 * Created by brian on 8/7/15.
 */
@Annotations.Model
public class SettingsModel {
    Settings settings;
    public SettingsModel() {
        this.settings = BeanLoader.get().get(Settings.class);
    }

    @Annotations.AuraEnabled
    public List<String> getMachineTypes() {
        return MachineFactory.getMachineNames();
    }

    @Annotations.AuraEnabled
    public String getCurrentMachine() {
        return settings.getMachineType();
    }

    @Annotations.AuraEnabled
    public String getCurrentPort() {
        return settings.getPort();
    }
}
