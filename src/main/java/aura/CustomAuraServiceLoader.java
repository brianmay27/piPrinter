package aura;

import context.BeanLoader;
import org.auraframework.ds.serviceloader.AuraServiceProvider;
import org.auraframework.util.ServiceLoader;

import java.util.Set;

/**
 * Created by brian on 7/20/15.
 */
public class CustomAuraServiceLoader implements ServiceLoader {
    @Override
    public <T extends AuraServiceProvider> T get(Class<T> type) {
        return BeanLoader.get().get(type);
    }

    @Override
    public <T extends AuraServiceProvider> T get(Class<T> type, String name) {
        return null;
    }

    @Override
    public <T extends AuraServiceProvider> Set<T> getAll(Class<T> type) {
        return null;
    }
}
