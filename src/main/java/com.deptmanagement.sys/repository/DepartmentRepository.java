package com.deptmanagement.sys.repository;

import com.deptmanagement.sys.domain.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p> Repository interface for DepartmentEntity. </p>
 */
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
}

