package pers.yuanwy.bus.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import pers.yuanwy.bus.client.UserFeignClient;
import pers.yuanwy.bus.dto.UserDTO;

@RestController
public class OrderController {

	@Autowired
	private UserFeignClient userFeignClient;

	@SuppressWarnings("unused")
	private final Random rnd = new Random(System.currentTimeMillis());

	@GetMapping("/order/{userId}/{orderNo}")
	@HystrixCommand(fallbackMethod = "findOrderFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public String findOrder(@PathVariable Integer userId, @PathVariable String orderNo, HttpServletRequest request)
			throws InterruptedException {
		// Thread.sleep(rnd.nextInt(1200));
		UserDTO user = userFeignClient.findUser(userId);
		if (user != null) {
			return user.getUserName() + " 的订单" + orderNo + " 找到啦！ url:" + request.getRequestURI() + ",port:"
					+ request.getLocalPort();
		}
		return "用户不存在！";
	}

	public String findOrderFallback(Integer userId, String orderNo, HttpServletRequest request) {
		return "订单查找失败！ url:" + request.getRequestURI() + ",port:" + request.getLocalPort();
	}

}