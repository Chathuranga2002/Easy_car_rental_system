package lk.ijse.Easy_car_rental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lk.ijse.Easy_car_rental.controller","lk.ijse.Easy_car_rental.advisor"})
public class WebAppConfig {
    public WebAppConfig(){
        System.out.println("WebAppConfig:Web App Instantiated");
    }
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(10485760);
        resolver.setMaxInMemorySize(1048576);
        return resolver;
    }
}
