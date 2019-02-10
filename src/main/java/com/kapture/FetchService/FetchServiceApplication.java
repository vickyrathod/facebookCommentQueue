package com.kapture.FetchService;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;

import com.kapture.model.RequstData;

@SpringBootApplication
@ComponentScan("com.kapture")
@EnableScheduling
@EnableMongoRepositories(basePackageClasses = com.kapture.dao.MRepository.class)
public class FetchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetchServiceApplication.class, args);
	}
}

