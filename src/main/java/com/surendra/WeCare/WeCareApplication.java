package com.surendra.WeCare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.surendra.WeCare.*")
@EntityScan("com.surendra.WeCare.entity")

public class WeCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeCareApplication.class, args);
	}

}
