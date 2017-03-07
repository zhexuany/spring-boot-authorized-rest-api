package edu.global.sgs.api.repository;


import edu.global.sgs.api.domain.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
    
    @Override
    @PreAuthorize("#course?.admin == null or #course?.admin?.name == authentication?.name")
    Course save(@Param("course") Course course);

    @Override
    @PreAuthorize("@courseRepository.findOne(#id)?.admin?.name == authentication?.name")
    void delete(@Param("id") Long id);

    @Override
    @PreAuthorize("#course?.admin?.name == authentication?.name")
    void delete(@Param("course") Course course);


}
