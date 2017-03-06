package edu.global.sgs.repository;

import edu.global.sgs.domain.Admin;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface AdminRepository extends Repository<Admin, Long> {

    Admin save(Admin manager);

    Admin findByName(String name);

}
