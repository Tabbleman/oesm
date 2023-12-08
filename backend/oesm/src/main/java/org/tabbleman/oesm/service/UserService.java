package org.tabbleman.oesm.service;

import org.tabbleman.oesm.entity.User;
import org.tabbleman.oesm.repository.UserRepository;

import java.util.List;

public interface UserService {
    public int register(User user);
    public int login(User user);

    public User getUserByName(String userName);

    public List<User> getAllUsers();

}
