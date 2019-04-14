/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib.com.config;

import com.sun.faces.config.FacesInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author LEOGOLD
 */
public class LibInitializer extends FacesInitializer implements WebApplicationInitializer{

@Override
public void onStartup(ServletContext sc) throws ServletException {

AnnotationConfigWebApplicationContext annotationCfg = new AnnotationConfigWebApplicationContext();
annotationCfg.setConfigLocation("lib.com.config"); //register(MovieConfiguration.class,HibernateConfig.class);
sc.addListener(new ContextLoaderListener(annotationCfg));

}


}
