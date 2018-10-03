package com.example.springsecurity_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@EntityScan(basePackages = "com.example.springsecurity_mybatis.entity")
@MapperScan(basePackages = "com.example.springsecurity_mybatis.*",
		sqlSessionFactoryRef = "sqlSessionFactory",
		sqlSessionTemplateRef = "sqlSessionTemplate",
		annotationClass = Repository.class)
public class SpringsecurityMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityMybatisApplication.class, args);
	}
}
