// package com.recharge.mobilerecharge.repository;

// import com.recharge.mobilerecharge.model.User;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface UserRepo extends JpaRepository<User, Long> {
//     User findByEmail(String email);
// }

package com.zenyoga.naveen.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zenyoga.naveen.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);

}