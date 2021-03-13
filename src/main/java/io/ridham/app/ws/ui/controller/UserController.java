package io.ridham.app.ws.ui.controller;

import io.ridham.app.ws.service.UserService;
import io.ridham.app.ws.shared.dto.UserDto;
import io.ridham.app.ws.ui.model.request.UserDetailsRequestModel;
import io.ridham.app.ws.ui.model.response.UserDetailsResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")                // http://localhost:8080/users
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String getUsers() {
		return "getUsers() called";
	}

	@PostMapping
	public UserDetailsResponseModel createUsers(@RequestBody UserDetailsRequestModel userDetails) {

		UserDetailsResponseModel responseModel = new UserDetailsResponseModel();

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);

		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, responseModel);

		return responseModel;
	}

	@PutMapping
	public String updateUsers() {
		return "updateUsers() called";
	}

	@DeleteMapping
	public String deleteUsers() {
		return "deleteUsers() called";
	}
}
