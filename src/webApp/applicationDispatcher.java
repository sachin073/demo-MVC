package webApp;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by sachin on 24/2/18.
 */

public class applicationDispatcher extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected String[] getServletMappings() {

        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class<?>[]{RootContext.class};
    }

}
