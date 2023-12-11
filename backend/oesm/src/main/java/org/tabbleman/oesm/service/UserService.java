package org.tabbleman.oesm.service;

import org.tabbleman.oesm.entity.User;
import org.tabbleman.oesm.repository.UserRepository;
import org.tabbleman.oesm.utils.dto.LoginDto;
import org.tabbleman.oesm.utils.dto.RegisterDto;

import java.util.List;

public interface UserService {
    public int register(RegisterDto registerDto);
    public User login(LoginDto loginDto);

    public User getUserByName(String userName);

    public List<User> getAllUsers();

}
