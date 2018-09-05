package pers.yuanwy.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pers.yuanwy.spring.entity.User;
import pers.yuanwy.spring.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@GetMapping("/list")
	public List<User> list() {
		log.info("UserController :: Method [list]");
		return userRepository.findAll();
	}

	@GetMapping("/get/{id}")
	public User get(@PathVariable Long id) {
		log.info("UserController :: Method [get]");
		return userRepository.getOne(id);
	}

}