package edu.global.sgs.api.hander;

import edu.global.sgs.api.domain.User;
import edu.global.sgs.api.domain.Admin;
import edu.global.sgs.api.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "edu.global.sgs.handler")
//@RepositoryEventHandler(User.class)
public class SpringDataRestEventHandler {

    private final AdminRepository adminRepository;

    @Autowired
    public SpringDataRestEventHandler(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @HandleBeforeCreate
    public void applyUserInformationUsingSecurityContext(User user) {

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Admin admin = this.adminRepository.findByName(name);
        if (admin == null) {
            Admin newAdmin = new Admin();
            newAdmin.setName(name);
            newAdmin.setRoles(new String[]{"ROLE_ADMIN"});
            admin = this.adminRepository.save(newAdmin);
        }
        user.setAdmin(admin);
    }
}
