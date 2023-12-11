package org.tabbleman.oesm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tabbleman.oesm.entity.User;
import org.tabbleman.oesm.repository.UserRepository;
import org.tabbleman.oesm.service.UserService;
import org.tabbleman.oesm.utils.dto.LoginDto;
import org.tabbleman.oesm.utils.dto.RegisterDto;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * register user, todo consider if the user exists.
     * @param user
     * @return
     * 1-100(include)   OK
     * 101-200          User Exists // todo
     * 201-300          Error
     */
    @Override
    public int register(RegisterDto registerDto) {
        try {
            User user = new User();
            String userName = registerDto.getUserName(), userPassword = registerDto.getUserPassword();
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            userRepository.save(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 201;
        }
    }

    /**
     *
     * @param user
     * @return
     * 1-100(include)   OK
     * 101-200          Password error
     * 201-300          Not register
     * 301-400          Error, todo put error in try-catch block
     */
    @Override
    public Long login(LoginDto loginDto) {
        String userName = loginDto.getUserName();
        String userPassword = loginDto.getUserPassword();

        String dbPassword = userRepository.findByUserName(userName).getUserPassword();
        if(dbPassword != null){
            if(dbPassword.equals(userPassword)){
                return 1L;
            }
            return 101L;
        }else {
            // password emptinity will be check in frontend;
            // user not register!user
            return 201L;
        }
    }

    /**
     * this function probably will be called by teacher
     * or logined student(maybe to change their password,
     *
     * @param userName
     * @return
     */
    @Override
    public User getUserByName(String userName) {
        User user = userRepository.findByUserName(userName);
        if(user != null){
            return user;
        }else {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        if(allUsers.isEmpty()){
            return null;
        }else{
            return allUsers;
        }
    }
}