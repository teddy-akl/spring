package pers.yuanwy.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pers.yuanwy.spring.dto.ResultDto;
import pers.yuanwy.spring.entity.User;
import pers.yuanwy.spring.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@PostMapping("/login")
	public User login(@RequestBody User entity) {
		log.info("user==" + entity.getUsername() + ":" + entity.getPassword());
		return userRepository.findByUserName(entity.getUsername());
	}

	@GetMapping("/logout")
	public Map<String, String> logout() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("errcode", "0");
		map.put("errmsg", "退出完成");
		return map;
	}

	@GetMapping("/list")
	public ResultDto list() {
		List<User> users = userRepository.findAll();
		return new ResultDto(true, "查询成功", users);
	}

	@GetMapping("/get/{id}")
	public ResultDto get(@PathVariable Long id) {
		User user = userRepository.getOne(id);
		return new ResultDto(true, "获取成功", user);
	}

	@PostMapping("/save")
	public ResultDto save(@RequestBody User entity) {
		userRepository.save(entity);
		return new ResultDto(true, "保存成功", entity.getId());
	}

	@GetMapping("remove/{id}")
	public ResultDto remove(@PathVariable Long id) {
		userRepository.deleteById(id);
		return new ResultDto(true, "删除成功", id);
	}

}
