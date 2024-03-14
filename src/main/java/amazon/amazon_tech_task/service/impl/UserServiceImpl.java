package amazon.amazon_tech_task.service.impl;

import amazon.amazon_tech_task.dto.request.SingUpRequest;
import amazon.amazon_tech_task.model.Role;
import amazon.amazon_tech_task.model.User;
import amazon.amazon_tech_task.repository.UserRepository;
import amazon.amazon_tech_task.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private  final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User already exist.");
        }

        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User with same email already exist.");
        }

        return save(user);
    }

    public User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));

    }
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

    private User save(User user) {
        return repository.save(user);
    }

    @Deprecated
    public void getAdmin() {
        var user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        save(user);
    }
}

