package configuration;

import aura.CustomAuraServiceLocator;
import aura.CustomConfigAdapterImpl;
import org.auraframework.adapter.ConfigAdapter;
import org.auraframework.util.ServiceLoaderImpl;
import org.auraframework.util.ServiceLocatorConfigurator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import replicatorg.app.Printer;

/**
 * Created by brian on 7/20/15.
 */
@Configuration
@ServiceLoaderImpl.AuraConfiguration
@Lazy
public class AuraConfiguration {

    @ServiceLoaderImpl.Impl
    public static ServiceLocatorConfigurator auraImplPrintServiceLocatiorConfig() {
        return new CustomAuraServiceLocator();
    }

    @Bean
    @Primary
    public ConfigAdapter getConfigAdapter() {
        return new CustomConfigAdapterImpl();
    }

    @Bean
    public Printer getPrinter() {
        return new Printer();
    }
}
