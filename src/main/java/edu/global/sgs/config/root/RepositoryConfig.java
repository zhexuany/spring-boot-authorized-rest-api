package edu.global.sgs.config.root;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("edu.global.sgs.repository")
public class RepositoryConfig {
}
