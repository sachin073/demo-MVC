package webApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;
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
/*    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }*/

/*

    @Bean
    public ViewResolver getCnViewResolver(ContentNegotiationManager cnMgr){
        ContentNegotiatingViewResolver view=  new ContentNegotiatingViewResolver();
        view.setContentNegotiationManager(cnMgr);
        return view;
    }


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
     //   super.configureContentNegotiation(configurer);
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }
*/

    // serve file for img.
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // for rest api but still not working... using msg converter via @ResponseBody annotation in controller
  /*  @Bean
    public ViewResolver beanNameViewResolver() {
        return new BeanNameViewResolver();
    }
*/
/*
    @Bean
    public View restEmp(){
        return new MappingJackson2JsonView();
    }
*/

    @Bean
     public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[] {
                "/WEB-INF/layouts/tiles.xml"
        });
        tiles.setCheckRefresh(true);
        return tiles;
    }

/*    @Bean
    public ViewResolver viewResolver() {
        return new TilesViewResolver();
    }*/

    @Bean
    public TilesViewResolver tilesViewResolver() {
        final TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }


}
