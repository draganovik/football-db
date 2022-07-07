package server;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger implements WebMvcConfigurer {

    public static final Contact DEFAULT_CONTACT = new Contact("Mladen Draganović", "https://github.com/draganovik",
            "draganovic.it68.2019@uns.ac.rs");

    @SuppressWarnings("rawtypes")
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Backend RVA Swagger", "Razvoj viseslojnih aplikacija",
            "1.0", "", DEFAULT_CONTACT, "", "", new ArrayList<VendorExtension>());

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("server"))
                .build().apiInfo(DEFAULT_API_INFO);
    }

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/swagger-ui/");
        registry.addRedirectViewController("/swagger-ui.html", "/swagger-ui/");
        registry.addRedirectViewController("/swagger-ui", "/swagger-ui/");
    }

}