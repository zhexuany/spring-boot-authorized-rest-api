package edu.global.sgs.www.config.root;


import edu.global.sgs.www.account.repository.RoleRepository;
import edu.global.sgs.www.account.repository.UserRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {UserRepository.class, RoleRepository.class})
public class RepositoryConfig {
}
