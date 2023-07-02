package com.example.UserApp.service;


import com.example.UserApp.entity.UserDetail;
import com.example.UserApp.repository.UserDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserDetailService {
    @Autowired
    private UserDetailRepository userDetailRepository;

    public UserDetail addUserDetail(UserDetail userDetail){
        return userDetailRepository.save(userDetail);
    }

    public UserDetail getUser(Long id) throws Exception {
       Optional<UserDetail> userDetail =  userDetailRepository.findById(id);
       if(userDetail.isPresent()){
           return userDetail.get();
       }else{
           log.info("No user found with id = {}",id);
           throw new Exception("No user found with id = " + id);
       }
    }
}
