package edu.global.sgs.api.config.data;

import edu.global.sgs.api.domain.User;
import edu.global.sgs.api.repository.AdminRepository;
import edu.global.sgs.api.repository.UserRepository;
import edu.global.sgs.api.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final UserRepository users;
    private final AdminRepository admins;

    @Autowired
    public DatabaseLoader(UserRepository employeeRepository,
                          AdminRepository managerRepository) {

        this.users = employeeRepository;
        this.admins = managerRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Admin greg, oliver;
        //init Admin and user if these admin isn't exist
        if (this.admins.findByName("greg") == null) {
            greg = this.admins.save(new Admin("greg", "turnquist",
                "ROLE_ADMIN"));

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken("greg", "doesn't matter",
                        AuthorityUtils.createAuthorityList("ROLE_ADMIN")));

        this.users.save(new User("Frodo", "Baggins", greg));
        this.users.save(new User("Bilbo", "Baggins", greg));
        this.users.save(new User("Gandalf", "the Grey", greg));

        }

        if (this.admins.findByName("greg") == null) {
            oliver = this.admins.save(new Admin("oliver", "gierke",
                "ROLE_ADMIN"));
            SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken("oliver", "doesn't matter",
                        AuthorityUtils.createAuthorityList("ROLE_ADMIN")));

            this.users.save(new User("Samwise", "Gamgee", oliver));
            this.users.save(new User("Merry", "Brandybuck", oliver));
            this.users.save(new User("Peregrin", "Took", oliver));
        }

        SecurityContextHolder.clearContext();
    }
}
