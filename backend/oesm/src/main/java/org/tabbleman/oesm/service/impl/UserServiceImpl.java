package org.tabbleman.oesm.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tabbleman.oesm.entity.Question;
import org.tabbleman.oesm.entity.User;
import org.tabbleman.oesm.repository.UserRepository;
import org.tabbleman.oesm.service.UserService;
import org.tabbleman.oesm.utils.dto.LoginDto;
import org.tabbleman.oesm.utils.dto.RegisterDto;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * register user, todo consider if the user exists.
     * @param registerDto
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
     * @param loginDto
     * @return
     * 1-100(include)   OK
     * 101-200          Password error
     * 201-300          Not register
     * 301-400          Error, todo put error in try-catch block
     */
    @Override
    public User login(LoginDto loginDto) {
        String userName = loginDto.getUserName();
        String userPassword = loginDto.getUserPassword();

        String dbPassword = userRepository.findByUserName(userName).getUserPassword();
        User responseUser = new User();
        log.info("call login");
        if(dbPassword != null){
            if(dbPassword.equals(userPassword)){
                // login successfully
                User user = userRepository.findByUserName(userName);
                responseUser = user;
                return responseUser;
            }
            return responseUser;
        }else {
            // password emptinity will be check in frontend;
            // user not register!user
            return responseUser;
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

    @Override
    public String uploadUserInfo(MultipartFile questionCsv) {

        try{
            InputStream is = questionCsv.getInputStream ();
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            List<Question> questions = new ArrayList<>();
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(buf);

            for(CSVRecord record : csvParser){
                String userName = record.get("userName");
                Long userClassId = Long.parseLong(record.get("userClassId"));
                String userRealName = record.get("userRealName");
                String userPassword = record.get("userPassword");
                Long userRoleLevel = Long.parseLong(record.get("userRoleLevel"));
                String userEmail = record.get("userEmail");
                User user = new User(userName, userClassId, userRealName, userPassword, userRoleLevel, userEmail);

                userRepository.save(user);
                log.info("User saved successfully!");
            }
            return "OK";
        }catch (Exception e){
            e.printStackTrace();
        }

        return "Error!";
    }
}
