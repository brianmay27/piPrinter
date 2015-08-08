package print;

import configuration.Settings;
import context.BeanLoader;
import org.auraframework.system.Annotations;

/**
 * Created by brian on 8/7/15.
 */
@Annotations.Controller
public class SettingsController {

    @Annotations.AuraEnabled
    public static void update(@Annotations.Key(value = "machine") String machine,
                              @Annotations.Key(value = "port") String port) {
        Settings settings = BeanLoader.get().get(Settings.class);
        settings.update(machine, port);
    }
}
