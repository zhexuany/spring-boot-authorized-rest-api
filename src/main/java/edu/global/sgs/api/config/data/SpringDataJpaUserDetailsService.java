package edu.global.sgs.api.config.data;

import edu.global.sgs.api.domain.Admin;
import edu.global.sgs.api.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringDataJpaUserDetailsService implements UserDetailsService {

    private final AdminRepository repository;

    @Autowired
    public SpringDataJpaUserDetailsService(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Admin admin = this.repository.findByName(name);
        return new User(admin.getName(), admin.getPassword(),
                AuthorityUtils.createAuthorityList(admin.getRoles()));
    }
}
