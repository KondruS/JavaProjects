package com.example.spring.services;

import com.example.spring.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PwdMgmtServc {

    public User getUserData(String id, String name) {
      User user=new User("a","b","a");
      return user;
    }

    public List<User> loadData() {
      User user=new User("123","Anj","Google");
              //User.builder().pwd("123").username("Anj").group("Google").build();
    /*  User user1=User.builder().pwd("456").username("Anjali").group("Google").build();
      User user2=User.builder().pwd("789").username("Anjali").group("Google").build();
      User user3=User.builder().pwd("012").username("Anjali").group("Google").build();
      User user4=User.builder().pwd("987").username("Anjali").group("Google").build();*/



      List<User> userList=new ArrayList<>();
      userList.add(user);
  /*    userList.add(user1);
      userList.add(user2);
      userList.add(user3);
      userList.add(user4);*/

      return userList;

    }
}
