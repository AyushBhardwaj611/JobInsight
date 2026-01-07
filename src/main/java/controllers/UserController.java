package controllers;

import dto.UserRequestDTO;
import dto.UserResponseDTO;
import exceptions.UserAlreadyExistsException;
import model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> CreateUserProfile (@RequestBody UserRequestDTO userRequestDTO) throws UserAlreadyExistsException {
        User user = userService.createUserProfile(userRequestDTO);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUser(user);

        return ResponseEntity.ok(userResponseDTO);
    }
}
