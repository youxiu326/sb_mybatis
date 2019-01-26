package com.huarui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.huarui.dao")
public class SbMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMybatisApplication.class, args);
	}

}

