package com.jts;

import io.r2dbc.spi.ConnectionFactory;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author Sandesh Jain
 */
@OpenAPIDefinition(info = @Info(title = "Tutorials Reactive REST API(H2 Database) Documentation", description = "Sandesh_Jain_Publication Reactive REST API Documentation", version = "v1", contact = @Contact(name = "Sandesh Jain", email = "tutor@sandesh-jain.com", url = "https://www.sandesh-jain.com"), license = @License(name = "Apache 2.0", url = "https://www.sandesh-jain.com")), externalDocs = @ExternalDocumentation(description = "Sandesh_Jain_Publication Reactive REST API Documentation", url = "http://localhost:8080/webjars/swagger-ui/index.html"))
@SpringBootApplication
@EnableWebFlux
public class ReactiveSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSpringBootApplication.class, args);
	}

	@Bean
	ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
		return initializer;
	}

}
