package com.example.spring.controller;

import com.example.spring.dto.User;
import com.example.spring.services.PwdMgmtServc;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Password Management Rest Controller")
@RestController
public class PwdMgmtController {

    @Autowired
    PwdMgmtServc pwdMgmtServc;

    @InitBinder
    public void initBinder(User user) {
        System.out.println("In the init Binder method! ");
    }

    @GetMapping(value = "/getUser/{id}/{name}",
            produces = "MediaType.APPLICATION_JSON", consumes = "MediaType.APPLICATION_XML" )
    public ResponseEntity<User> getData(@PathVariable("id") String id, @PathVariable("name") String name) {
        //User user = new User();
        return new ResponseEntity<>(pwdMgmtServc.getUserData(id, name), HttpStatus.OK);
    }

    @GetMapping(value = "/loadData")
    public void loadData() {
       pwdMgmtServc.loadData();
    }

    @PostMapping("/CreateUser/")
    public ResponseEntity<User> addUserData(@RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/CreateUser/" ,
            params = "version-1",
            headers = "X-API-Version-1",
            produces = "application/vnd.pmt.app-v1+json") //application/vnd.myapi.v2+json
    public ResponseEntity<User> addUserDataCoverage(@RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/UpdateUser/{id}")
    public ResponseEntity<String> UpdateUserData(@PathVariable("id") String id) {
        //User user = new User();
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteUser/{id}")
    public ResponseEntity<String> deletUserData(@PathVariable("id") String id) {
        //User user = new User();
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PatchMapping("/UpdateUserPatch/")
    public ResponseEntity<User> UpdatePatchUserData(@RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
