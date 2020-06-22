package ru.kpfu.formsvalidation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = {"ru.kpfu.formsvalidation.controller"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/jsp/");
    resolver.setSuffix(".jsp");
    resolver.setViewClass(JstlView.class);
    resolver.setRedirectContextRelative(false);
    return resolver;
  }

  //bugfix for "No message found under code 'name.empty.author.name' for locale 'ru_RU'."
//  @Bean
//  public MessageSource messageSource() {
//    return new MessageSource() {
//      DelegatingMessageSource source = new DelegatingMessageSource();
//      @Override
//      public String getMessage(String s, Object[] objects, String s1, Locale locale) {
//        return source.getMessage(s,objects,s1,Locale.ENGLISH);
//      }
//
//      @Override
//      public String getMessage(String s, Object[] objects, Locale locale) throws NoSuchMessageException {
//        return "error message1";
//      }
//
//      @Override
//      public String getMessage(MessageSourceResolvable messageSourceResolvable, Locale locale) throws NoSuchMessageException {
//        return source.getMessage(messageSourceResolvable,Locale.ENGLISH);
//      }
//    };
//  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("index");
  }

  @Bean("validator")
  public LocalValidatorFactoryBean localValidatorFactoryBean() {
    return new LocalValidatorFactoryBean();
  }
}
