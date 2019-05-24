package marc;
import org.apache.camel.LoggingLevel;
import  org.apache.camel.model.rest.RestBindingMode;
import org.springframework.context.annotation.Bean;
import java.lang.annotation.*;

import javax.annotation.*;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component
public class MySimpleCamelRouter extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    restConfiguration()
      .component("servlet")
      .bindingMode(RestBindingMode.auto);

    rest().get("/hello")
      .to("direct:hello");
 
    from("direct:hello")
      .log(LoggingLevel.INFO, "Hello World")
      .transform().constant("Hello World");
   }
}
