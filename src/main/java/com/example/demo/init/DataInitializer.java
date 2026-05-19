package com.example.demo.init;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;


    @Override
    public void run(String... args) {
        Role adminRole = userService.getRoleByName("ROLE_ADMIN");
        if (adminRole == null) {
            adminRole = new Role("ROLE_ADMIN");
            userService.saveRole(adminRole);
        }

        Role userRole = userService.getRoleByName("ROLE_USER");
        if (userRole == null) {
            userRole = new Role("ROLE_USER");
            userService.saveRole(userRole);
        }

        if (userService.getUserByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword("100");
            admin.setEmail("admin@mail.ru");
            admin.setRoles(Set.of(adminRole, userRole));
            userService.saveOrUpdateUser(admin);
        }

        if (userService.getUserByUsername("user") == null) {
            User user = new User();
            user.setUsername("user");
            user.setPassword("100");
            user.setEmail("user@mail.ru");
            user.setRoles(Set.of(userRole));
            userService.saveOrUpdateUser(user);
        }
    }
}