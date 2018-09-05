package pers.yuanwy.bus.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.yuanwy.bus.config.ProviderConfig;
import pers.yuanwy.bus.dto.UserDTO;
import pers.yuanwy.bus.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    ProviderConfig config;

    @Override
    public UserDTO findUser(Integer userId) {
        UserDTO user = new UserDTO();
        user.setUserId(userId);
        user.setUserName("菩提树下的杨过(" + config.getTitle() + ")");
        return user;
    }
}