package com.deptmanagement.sys.repository;

import com.deptmanagement.sys.domain.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p> Repository interface for managing StudentEntity. </p>
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

    /**
     * <p> Finds all students by department ID. </p>
     *
     * @param deptId <p> ID of the department. </p>
     * @return <p> List of students in the specified department. </p>
     */
    List<StudentEntity> findByDepartment_DeptId(int deptId);
}
