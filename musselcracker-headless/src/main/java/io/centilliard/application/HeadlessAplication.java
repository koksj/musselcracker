package io.centilliard.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@ApplicationPath("/api")
@OpenAPIDefinition(info = @Info(title = "Musslecraker Headless CMS", version = "v1"))
public class HeadlessAplication extends Application {


    
}
