package sig.org.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
  
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //
        // Access Bootstrap static resource:
        //
  

        registry.addResourceHandler("/bootstrap/**") //
                .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.1.1/");
  
    }
  
}