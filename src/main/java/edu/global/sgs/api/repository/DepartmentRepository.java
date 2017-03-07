package edu.global.sgs.api.repository;

import edu.global.sgs.api.domain.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
    
    @Override
    @PreAuthorize("#department?.admin == null or #department?.admin?.name == authentication?.name")
    Department save(@Param("department") Department department);

    @Override
    @PreAuthorize("@departmentRepository.findOne(#id)?.admin?.name == authentication?.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("#department?.admin?.name == authentication?.name")
    void delete(@Param("department") Department department);


}
