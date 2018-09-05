package pers.yuanwy.bus;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ServiceGateway {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServiceGateway.class).web(true).run(args);
	}

}