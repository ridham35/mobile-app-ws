package io.ridham.app.ws.service.impl;

import io.ridham.app.ws.UserRepository;
import io.ridham.app.ws.entity.UserEntity;
import io.ridham.app.ws.service.UserService;
import io.ridham.app.ws.shared.Utils;
import io.ridham.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Utils utils;

	@Override
	public UserDto createUser(UserDto userDto) {

		if (userRepository.findByEmail(userDto.getEmail()) != null) throw new RuntimeException("Record already exist!");

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);

		String publicUserId = utils.generatedUserId(30);
		userEntity.setUserId(publicUserId);
		userEntity.setEncryptedPassword("testEncryptedPassword");

		UserEntity storedUserDetail = userRepository.save(userEntity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetail, returnValue);

		return returnValue;
	}
}
