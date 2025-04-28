package org.com.Repository;


import java.util.Optional;

import org.com.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findByUsername(String username);
}
