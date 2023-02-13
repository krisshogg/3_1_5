package com.andreyb34rus.JM_Task_3_1_1.configs;

import com.andreyb34rus.JM_Task_3_1_1.model.Role;
import com.andreyb34rus.JM_Task_3_1_1.model.User;
import com.andreyb34rus.JM_Task_3_1_1.repository.RoleRepository;
import com.andreyb34rus.JM_Task_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner {
    private UserService userService;
    private final RoleRepository roleRepository;


    @Autowired
    public DataLoader(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    public void run(ApplicationArguments args) {

        Role userRole = new Role("ROLE_USER");
        Role adminRole = new Role("ROLE_ADMIN");

        roleRepository.save(userRole);
        roleRepository.save(adminRole);

        User user1 = new User("user", "user", "fdfok@fifi.com");
        User user2 = new User("admin", "admin", "fdfok@fifi.com");

        user1.setRoles(new HashSet<>(Set.of(userRole)));
        user2.setRoles(new HashSet<>(Set.of(adminRole, userRole)));

        userService.saveRole(userRole);
        userService.saveRole(adminRole);

        userService.save(user1);
        userService.save(user2);
    }
}





