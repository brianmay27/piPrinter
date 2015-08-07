package context;

import configuration.BeanConfiguration;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
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

    private synchronized void init() {
        if (ac != null) {
            return;
        }
        try {
            ac = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        } catch (Exception e) {

        }
    }

    public <T> T get(Class<T> clazz) {
        if (ac == null) {
            init();
        }
        try {
            return ac == null ? null : ac.getBean(clazz);
        } catch (NoSuchBeanDefinitionException e) {
            return null;
        }
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
