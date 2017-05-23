package com.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoostcampBackendStudyApplication {
	private static Logger logger = LoggerFactory.getLogger(BoostcampBackendStudyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BoostcampBackendStudyApplication.class, args);
		logger.info("hello");
	}
}
