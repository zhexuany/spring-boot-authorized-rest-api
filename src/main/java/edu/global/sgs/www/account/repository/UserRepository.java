package edu.global.sgs.www.account.repository;

import edu.global.sgs.www.account.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
