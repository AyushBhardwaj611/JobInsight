package repositories;

import dto.UserRequestDTO;
import model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {
    public HashMap<String, User> userProfileMap = new HashMap<>();

    public void addUserProfile(User user) {
        userProfileMap.put(user.getName(), user);
    }

    public User getUserProfile(String name) {
        return userProfileMap.get(name);
    }
}
