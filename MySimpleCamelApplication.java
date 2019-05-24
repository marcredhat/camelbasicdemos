@SpringBootApplication
@Configuration
@ComponentScan("com.simple.camel.project")
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
