package webApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import webApp.webControllers.Home;

/**
 * Created by sachin on 24/2/18.
 No view resolver is configured. As such, Spring will default to using Bean-
 NameViewResolver , a view resolver that resolves views by looking for beans whose
 ID matches the view name .

 */

@Configuration
@EnableWebMvc
// below is component scan for web context
@ComponentScan(basePackageClasses = Home.class)
public class WebConfig  extends WebMvcConfigurerAdapter{


//jsp resolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }


    // serve file for img.
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
