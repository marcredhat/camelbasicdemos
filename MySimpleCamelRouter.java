@Component
public class MySimpleCamelRouter extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    restConfiguration()
      .component("servlet")
      .bindingMode(RestBindingMode.json);

    rest().get("/hello")
      .to("direct:hello");
 
    from("direct:hello")
      .log(LoggingLevel.INFO, "Hello World")
      .transform().simple("Hello World");
   }
}
