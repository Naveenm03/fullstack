// package com.recharge.mobilerecharge.service;

// import com.recharge.mobilerecharge.model.User;

// import java.util.List;

// public interface UserService {

//     User saveUser(User user);
// }


// package com.zenyoga.naveen.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.zenyoga.naveen.entity.User;
// import com.zenyoga.naveen.repository.UserRepository;

// @Service
// public class UserService {
//     @Autowired
//     UserRepository ur;
     
     
//      public boolean AddUser(User ue)
//      {
//           ur.save(ue);
//           return true;
//      }
//      public List<User> getUser()
//      {
//           return ur.findAll();
//      }
//      public Optional<User> getById(Long id)
//      {
//     	 return ur.findById(id);
//      }
// }         


package com.zenyoga.naveen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenyoga.naveen.entity.User;
import com.zenyoga.naveen.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            // Handle the case when the user with the given id doesn't exist
            return null;
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
