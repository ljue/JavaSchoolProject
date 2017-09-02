package com.jvschool.config;


import com.jvschool.util.RoleFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer{


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(servletContext);

        DispatcherServlet dp =  new DispatcherServlet(ctx);
        dp.setThrowExceptionIfNoHandlerFound(true);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dp);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

        servletContext.addFilter("RoleFilter", RoleFilter.class).addMappingForUrlPatterns(null, false, "/*");
    }
}
