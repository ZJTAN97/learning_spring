package io.getarrays.userservice.service;

import java.util.List;

import io.getarrays.userservice.entity.Role;
import io.getarrays.userservice.entity.User;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 7/10/2021
 */
public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
}
