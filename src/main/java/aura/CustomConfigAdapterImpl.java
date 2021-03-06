package aura;

import org.auraframework.impl.adapter.ConfigAdapterImpl;

/**
 * Created by brian on 7/20/15.
 */

public class CustomConfigAdapterImpl extends ConfigAdapterImpl {
    public CustomConfigAdapterImpl() {
    }

    @Override
    public boolean isPrivilegedNamespace(String namespace) {
        if (namespace != null && "print".contains(namespace)) {
            return true;
        }
        return super.isPrivilegedNamespace(namespace);
    }
}
