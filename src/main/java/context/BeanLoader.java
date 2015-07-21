package context;

import configuration.AuraConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by brian on 7/20/15.
 */
public class BeanLoader {
    private static ApplicationContext ac;
    public static BeanLoader get() {
        return BeanHolder.loader;
    }

    public BeanLoader() {

    }

    private void init() {
        try {
            ac = new AnnotationConfigApplicationContext(AuraConfiguration.class);
        } catch (Exception e) {

        }
    }

    public <T> T get(Class<T> clazz) {
        if (ac == null) {
            init();
        }
        return ac == null ? null :ac.getBean(clazz);
    }

    private static class BeanHolder {
        private static final BeanLoader loader = new BeanLoader();

        private BeanHolder() {

        }
        static {
            loader.init();
        }
    }
}
