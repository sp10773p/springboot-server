package io.dhseong.core.config;

import io.dhseong.core.config.listener.HttpSessionListenerImpl;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpSessionListener;

/**
 * @author dong hun Seong
 * @since 2018-02-05
 */
public class ApplicationSessionConfig {

    @Bean
    public ServletListenerRegistrationBean<HttpSessionListener> sessionListener()
    {
        return new ServletListenerRegistrationBean<HttpSessionListener>(new HttpSessionListenerImpl());
    }
}
