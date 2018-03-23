package eureka.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class EurekaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaZuulApplication.class, args);
	}
	
	/*@Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }*/

}
