package com.dub.config;

import javax.inject.Inject;

import com.dub.config.annotation.WebController;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.RequestToViewNameTranslator;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(
        basePackages = { "com.dub.site", "com.dub.entities" },
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(WebController.class)
)
public class ServletContextConfiguration extends WebMvcConfigurerAdapter
{
    @Inject ApplicationContext applicationContext;
    @Inject ObjectMapper objectMapper;
    @Inject Marshaller marshaller;
    @Inject Unmarshaller unmarshaller;
	@Inject SpringValidatorAdapter validator;
	
	@Override
	public Validator getValidator()
	{
	    return this.validator;
    }
	   
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        super.addInterceptors(registry);
        
        LocaleChangeInterceptor interceptor = 
        						new LocaleChangeInterceptor();
        //interceptor.setParamName("language");
       
        registry.addInterceptor(interceptor);
    }
    
    
    @Bean
    public LocaleResolver localeResolver()
    {
        return new SessionLocaleResolver();
    }

    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/view/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public RequestToViewNameTranslator viewNameTranslator()
    {
        return new DefaultRequestToViewNameTranslator();
    }

    @Bean
    public MultipartResolver multipartResolver()
    {
        return new StandardServletMultipartResolver();
    }
}
