package io.ridham.app.ws.service;

import io.ridham.app.ws.shared.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);
}
