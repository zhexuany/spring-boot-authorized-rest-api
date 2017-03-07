package edu.global.sgs.api.repository;

import edu.global.sgs.api.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Override
    @PreAuthorize("#user?.admin == null or #user?.admin?.name == authentication?.name")
    User save(@Param("user") User user);

    @Override
    @PreAuthorize("@userRepository.findOne(#id)?.admin?.name == authentication?.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("#user?.admin?.name == authentication?.name")
    void delete(@Param("user") User user);


}
