package eu.freakydirac.restfulspring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan("eu.freakydirac.restfulspring")
@EnableWebMvc
@EnableGlobalMethodSecurity(securedEnabled=true)
@Import({ SecurityConfig.class })
public class AppConfig {
}