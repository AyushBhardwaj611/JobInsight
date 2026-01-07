package services;

import dto.UserRequestDTO;
import exceptions.UserAlreadyExistsException;
import model.User;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUserProfile(UserRequestDTO userRequestDTO) throws UserAlreadyExistsException {

        User user = userRepository.userProfileMap.get(userRequestDTO.getName());

        User toSaveUser = new User();

        if (user != null) {
            throw new UserAlreadyExistsException("User with name " + userRequestDTO.getName() + " already exists.");
        }

        toSaveUser.setName(userRequestDTO.getName());
        toSaveUser.setAge(userRequestDTO.getAge());
        toSaveUser.setSkills(userRequestDTO.getSkills());
        toSaveUser.setExpectedSalary(userRequestDTO.getExpectedSalary());

        User savedUser = userRepository.userProfileMap.put(toSaveUser.getName(), toSaveUser);

        return savedUser;
    }
}
