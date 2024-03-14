package amazon.amazon_tech_task.service;

import amazon.amazon_tech_task.dto.request.SingUpRequest;
import amazon.amazon_tech_task.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    User create(User user);

    User getByUsername(String username);

    UserDetailsService userDetailsService();

    void getAdmin();
}
