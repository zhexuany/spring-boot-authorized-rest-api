package edu.global.sgs.api.repository;

import edu.global.sgs.api.domain.College;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface CollegeRepository extends PagingAndSortingRepository<College, Long> {
    
    @Override
    @PreAuthorize("#college?.admin == null or #college?.admin?.name == authentication?.name")
    College save(@Param("college") College college);

    @Override
    @PreAuthorize("@collegeRepository.findOne(#id)?.admin?.name == authentication?.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("#college?.admin?.name == authentication?.name")
    void delete(@Param("college") College college);


}
