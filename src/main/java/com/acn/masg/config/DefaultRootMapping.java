package com.acn.masg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class DefaultRootMapping extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/")
		.setViewName("redirect:/index.html");
		
		
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		super.addViewControllers(registry);
	}

}
