package com.deptmanagement.sys.services;

import com.deptmanagement.sys.domain.entity.DepartmentEntity;
import com.deptmanagement.sys.domain.entity.StudentEntity;
import com.deptmanagement.sys.dto.StudentDTO;

import java.util.List;

/**
 * <p> Interface defining department-related operations. </p>
 */
public interface IDepartmentService {

    /**
     * <p> Adds a new department to the system. </p>
     *
     * @param deptId The unique department ID.
     * @param name   The name of the department.
     */
    void addDepartment(Integer deptId, String name);

    /**
     * <p> Retrieves a list of all departments. </p>
     *
     * @return A list of department entities.
     */
    List<DepartmentEntity> getAllDepartments();

    /**
     * <p> Retrieves a department by its ID. </p>
     *
     * @param deptId The unique department ID.
     * @return The department entity if found, otherwise null.
     */
    DepartmentEntity getDepartmentById(Integer deptId);

    /**
     * <p> Updates the name of an existing department. </p>
     *
     * @param deptId  The unique department ID.
     * @param newName The new name for the department.
     */
    void updateDepartment(Integer deptId, String newName);

    /**
     * <p> Deletes a department from the system. </p>
     *
     * @param deptId The unique department ID.
     */
    void deleteDepartment(Integer deptId);

    /**
     * <p> Retrieves and displays students belonging to a specific department. </p>
     *
     * @param deptId The unique department ID.
     */
    List<StudentDTO> getStudentsByDepartment(Integer deptId);


}
