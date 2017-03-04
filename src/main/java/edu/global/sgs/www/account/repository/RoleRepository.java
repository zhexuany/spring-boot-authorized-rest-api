package edu.global.sgs.www.account.repository;

import edu.global.sgs.www.account.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
