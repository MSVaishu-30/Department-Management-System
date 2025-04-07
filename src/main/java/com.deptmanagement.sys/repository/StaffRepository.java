package com.deptmanagement.sys.repository;

import com.deptmanagement.sys.domain.entity.StaffEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p> Repository interface for managing StaffEntity in MongoDB. </p>
 */
@Repository
public interface StaffRepository extends MongoRepository<StaffEntity, String> {

    /**
     * <p> Finds staff members by department ID. </p>
     *
     * @param departmentId <p> The ID of the department. </p>
     * @return <p> List of staff belonging to the given department. </p>
     */
    List<StaffEntity> findByDepartmentId(int departmentId);
}
