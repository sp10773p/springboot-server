package io.dhseong;

import io.dhseong.core.config.listener.HttpSessionListenerImpl;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class Application /*extends SpringBootServletInitializer*/ {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return super.configure(builder);
//	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		configureApplication(new SpringApplicationBuilder()).run(args);
	}

//	private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
//		return builder.sources(Application.class).bannerMode(Banner.Mode.OFF);
//	}
}
