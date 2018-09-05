package pers.yuanwy.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
//@ComponentScan(basePackages = { "pers.yuanwy.bus", "pers.yuanwy.bus.provider" })
public class ServiceProvider {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProvider.class, args);
	}
}