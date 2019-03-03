package com.kapture.FetchService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.kapture")
@EnableScheduling
@EnableMongoRepositories(basePackageClasses = com.kapture.dao.MRepository.class)
public class FetchServiceApplication {

	private static Logger log = LogManager.getLogger(FetchServiceApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(FetchServiceApplication.class);
		Environment env = app.run(args).getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:{}\n" +
                "----------------------------------------------------------",
        env.getProperty("spring.application.name"),
        env.getProperty("server.port"));
	}
}

