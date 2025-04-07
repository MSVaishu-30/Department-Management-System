package com.deptmanagement.sys.services;

import com.deptmanagement.sys.domain.entity.StaffEntity;
import com.deptmanagement.sys.dto.StaffDTO;

import java.util.List;

/**
 * Interface for Staff Service.
 * Defines business logic operations for managing staff members.
 */
public interface IStaffService {

    /**
     * Adds a new staff member with the provided details.
     *
     * @param name the name of the staff member.
     * @param salary the salary of the staff member.
     * @param email the email of the staff member.
     * @param phoneNumber the phone number of the staff member.
     * @param position the position of the staff member.
     * @param departmentId the ID of the department the staff belongs to.
     * @return true if the staff member is successfully added, false otherwise.
     */
    boolean addStaff(String name, double salary, String email, String phoneNumber, String position, int departmentId);

    /**
     * Retrieves a staff member by their ID.
     *
     * @param id the ID of the staff member.
     * @return the StaffEntity object if found, otherwise null.
     */
    StaffDTO getStaffById(String id);

    /**
     * Retrieves a list of all staff members.
     *
     * @return a list of StaffEntity objects.
     */
    List<StaffDTO> getAllStaff();

    /**
     * Updates an existing staff member's details.
     *
     * @param id the ID of the staff member to update.
     * @param name the updated name of the staff member.
     * @param salary the updated salary of the staff member.
     * @param email the updated email of the staff member.
     * @param phoneNumber the updated phone number of the staff member.
     * @param position the updated position of the staff member.
     * @param departmentId the updated department ID of the staff member.
     * @return true if the update is successful, false otherwise.
     */
    boolean updateStaff(String id, String name, double salary, String email, String phoneNumber, String position, int departmentId); // Changed int to String

    /**
     * Deletes a staff member by their ID.
     *
     * @param id the ID of the staff member to delete.
     * @return true if deletion is successful, false otherwise.
     */
    boolean deleteStaff(String id); // Changed int to String

    /**
     * Retrieves a list of staff members belonging to a specific department.
     *
     * @param departmentId the ID of the department.
     * @return a list of StaffEntity objects in the specified department.
     */
    List<StaffDTO> getStaffByDepartment(int departmentId);
}
