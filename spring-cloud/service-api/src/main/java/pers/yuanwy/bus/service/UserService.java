package pers.yuanwy.bus.service;

import pers.yuanwy.bus.dto.UserDTO;

public interface UserService {

	UserDTO findUser(Integer userId);
}
