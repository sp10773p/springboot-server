package io.dhseong.core.config;

import io.dhseong.core.config.interceptor.CommonInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @author dong hun Seong
 * @since 2018-02-05
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        converters.add(gsonHttpMessageConverter);
    }

    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/extjs/index.html");
    }*/


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String[] RESOURCE_LOCATIONS = {
                "classpath:/extjs/",
                "classpath:/mapper/",
                "classpath:/META-INF/resources/",
                "classpath:/resources/"};

        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(
                    RESOURCE_LOCATIONS);
        }
    }
}
