package marc;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.context.annotation.*;
import org.apache.camel.*;

import org.apache.camel.LoggingLevel;
import  org.apache.camel.model.rest.RestBindingMode;
import org.springframework.context.annotation.Bean;
import java.lang.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.beans.*;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import javax.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@SpringBootApplication
@Configuration
//@EnableAutoConfiguration
public class MySimpleCamelApplication {
  /**
  * A main method to start this application.
  **/
  public static void main(String[] args) {
    SpringApplication.run(MySimpleCamelApplication.class, args);
  }
  /** 
  * from camel 2.21.0 on this ServletRegistrationBean is not required 
  * and the path defaults to /camel
  **/
  @Bean
  public ServletRegistrationBean camelServletRegistrationBean() {
    ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/camel/*");
    registration.setName("CamelServlet");
    return registration;
  }
 }
