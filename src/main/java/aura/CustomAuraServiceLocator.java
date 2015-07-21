package aura;

import com.google.common.collect.Lists;
import org.auraframework.util.ServiceLoader;
import org.auraframework.util.ServiceLoaderImpl;
import org.auraframework.util.ServiceLocatorConfigurator;

import java.util.List;

/**
 * Created by brian on 7/20/15.
 */
public class CustomAuraServiceLocator implements ServiceLocatorConfigurator {
    @Override
    public List<ServiceLoader> getServiceLoaders() {
        return Lists.newArrayList(new CustomAuraServiceLoader(), ServiceLoaderImpl.get());
    }
}
