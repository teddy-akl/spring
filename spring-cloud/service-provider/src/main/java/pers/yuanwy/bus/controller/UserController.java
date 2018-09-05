package pers.yuanwy.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pers.yuanwy.bus.dto.UserDTO;
import pers.yuanwy.bus.service.UserService;

@RestController
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public UserDTO findUser(@PathVariable Integer id) {
        return userService.findUser(id);
    }
    
}
