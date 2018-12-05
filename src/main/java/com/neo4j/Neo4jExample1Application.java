package com.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.neo4j")
// @EnableNeo4jRepositories(basePackages = "com.neo4j")
public class Neo4jExample1Application {

	public static void main(String[] args) {
		SpringApplication.run(Neo4jExample1Application.class, args);
	}
}
