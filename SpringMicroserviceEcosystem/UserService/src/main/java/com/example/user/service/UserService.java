package com.example.user.service;

import com.example.user.entity.UserInfo;
import com.example.user.repository.UserRepository;
import com.example.user.valueobject.Department;
import com.example.user.valueobject.UserDepartmentWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Slf4j
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public UserInfo saveUser(UserInfo userInfo) {
        log.info("Inside saveUser of UserService ");
        return userRepository.save(userInfo);
    }

    public UserDepartmentWrapper findUserWithDepartment(Long userId) {
        UserDepartmentWrapper wrapper = new UserDepartmentWrapper();
        Optional<UserInfo> user = userRepository.findById(userId);
        wrapper.setUserInfo(user.orElseThrow());

        Department department = restTemplate.getForObject
                ("http://DEPARTMENT-SERVICE/departments/"+user.get().getDepartmentId(), Department.class);
        wrapper.setDepartment(department);
        return wrapper;
    }
}
