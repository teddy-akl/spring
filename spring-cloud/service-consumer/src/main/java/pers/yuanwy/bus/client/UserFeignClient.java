package pers.yuanwy.bus.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pers.yuanwy.bus.dto.UserDTO;

@FeignClient(name = "service-provider", configuration = BasicAuthConfiguration.class)
public interface UserFeignClient {

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	UserDTO findUser(@PathVariable("id") Integer userId);

}
