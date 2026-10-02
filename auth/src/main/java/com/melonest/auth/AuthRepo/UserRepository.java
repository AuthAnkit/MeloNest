package com.melonest.auth.AuthRepo;

import com.melonest.auth.AuthModels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    Optional<User> findByusernameAndPassword(String username,String password);
    Optional<User> findByusernameAndEmail(String username,String email);
    Optional<User> findByusername(String username);
}
