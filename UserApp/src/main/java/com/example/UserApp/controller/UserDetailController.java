package com.example.UserApp.controller;


import com.example.UserApp.entity.UserDetail;
import com.example.UserApp.service.UserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserDetailController {

    @Autowired
    private UserDetailService userDetailService;

    @GetMapping("/user")
    public ResponseEntity getUserDetail(@RequestParam("user_id")Long userId){
        try {
            log.info("get user request = {}", userId);
            UserDetail userDetail = userDetailService.getUser(userId);
            return new ResponseEntity<UserDetail>(userDetail, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("some error has Occurred",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add-user")
    public ResponseEntity addUserDetail(@RequestBody UserDetail userDetail){
        try{
            log.info("add user request payload = {}",userDetail);
            UserDetail userDetail1 = userDetailService.addUserDetail(userDetail);
            return new ResponseEntity<UserDetail>(userDetail1, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
