package rest;

import errorhandling.GenericExceptionMapper;
import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.wadl.internal.WadlResource;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(errorhandling.GenericExceptionMapper.class);
        resources.add(org.glassfish.jersey.server.wadl.internal.WadlResource.class);
        resources.add(rest.GenericResource.class);
        resources.add(rest.PersonResource.class);
        resources.add(rest.RenameMeResource.class);
    }
    
}
