package edu.global.sgs.www.config;

import edu.global.sgs.www.config.web.WebSecurityConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityInitializer() {
        super(WebSecurityConfig.class);
    }

    /*
    public void onStartup(ServletContext container) throws ServletException {
        super.onStartup(container);
        //add custom filter for render chinese character correctly
        FilterRegistration.Dynamic filterRegistration = container.addFilter("charSet", new CharacterEncodingFilter());
        filterRegistration.setInitParameter("encoding", "UTF-8");
        filterRegistration.setInitParameter("forceEncoding", "true");
        filterRegistration.addMappingForUrlPatterns(null, true, "/*");
        
        configureAppContextInitializers(container, SpringApplicationContextInitializer.class.getName());
        createRootAppContext(container, RepositoryConfig.class);
        createDispatcherServlet(container, WebMvcConfig.class);
    }

    private void configureAppContextInitializers(ServletContext container, String... initClassNames) {
        String initializerClasses = container.getInitParameter(ContextLoader.CONTEXT_INITIALIZER_CLASSES_PARAM);

        String delimitedClassNames = StringUtils.arrayToDelimitedString(initClassNames, " ");

        if (StringUtils.hasText(initializerClasses)) {
            initializerClasses += " " + delimitedClassNames;
        }
        else {
            initializerClasses = delimitedClassNames;
        }

        container.setInitParameter(ContextLoader.CONTEXT_INITIALIZER_CLASSES_PARAM, initializerClasses);
    }

    private void createRootAppContext(ServletContext container, java.lang.Class<?>... configClasses) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(configClasses);
        container.addListener(new ContextLoaderListener(rootContext));
    }

    private void createDispatcherServlet(ServletContext container, java.lang.Class<?>... configClasses) {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(configClasses);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
    */
}
