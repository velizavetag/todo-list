package academy.learnprogramming.config;

import academy.learnprogramming.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.UrlBasedViewResolverRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
public class WebConfig implements WebMvcConfigurer {
//    constants
    public static final String RESOLVER_PREFIX = "/WEB-INF/view/";
    public static final String RESOLVER_SUFFIX= ".jsp";

//    bean methods
    @Bean
    public ViewResolver viewResolver(){
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

//        ViewcontrollerRegistry class assists with the simple autmated controllers
//        that are preconfigured with a status code or a view. this will be used fr our home view.
//        We are adding the view controller that is esentially an automated controller that is preconfigured with the home view.
//        when we open the app url, it will direct us to the home page.
        registry.addViewController("/").setViewName(ViewNames.HOME);
    }
}
