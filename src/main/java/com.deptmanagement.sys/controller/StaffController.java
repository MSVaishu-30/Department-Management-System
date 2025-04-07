package com.deptmanagement.sys.controller;

import com.deptmanagement.sys.domain.entity.StaffEntity;
import com.deptmanagement.sys.dto.StaffDTO;
import com.deptmanagement.sys.mapper.StaffMapper;
import com.deptmanagement.sys.services.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p> REST Controller for managing Staff operations. </p>
 */
@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {

    private final IStaffService staffService;
    private final StaffMapper staffMapper;

    /**
     * <p> Constructor for injecting staff service and mapper. </p>
     *
     * @param staffService <p> Service to manage staff operations. </p>
     * @param staffMapper <p> Mapper to convert between StaffEntity and StaffDTO. </p>
     */
    @Autowired
    public StaffController(IStaffService staffService, StaffMapper staffMapper) {
        this.staffService = staffService;
        this.staffMapper = staffMapper;
    }

    /**
     * <p> Add a new staff member. </p>
     *
     * @param staffDTO <p> Data of the staff to be added. </p>
     * @return <p> true if added successfully, false otherwise. </p>
     */
    @PostMapping("/add")
    public boolean addStaff(@RequestBody StaffDTO staffDTO) {
        return staffService.addStaff(
                staffDTO.getName(),
                staffDTO.getSalary(),
                staffDTO.getEmail(),
                staffDTO.getPhoneNumber(),
                staffDTO.getPosition(),
                staffDTO.getDepartmentId()
        );
    }

    /**
     * <p> Get staff details by ID. </p>
     *
     * @param id <p> Staff ID. </p>
     * @return <p> StaffDTO containing staff details. </p>
     */
    @GetMapping("/{id}")
    public StaffDTO getStaffById(@PathVariable String id) {
        return staffService.getStaffById(id);
    }

    /**
     * <p> Get all staff members. </p>
     *
     * @return <p> List of StaffDTO. </p>
     */
    @GetMapping("/all")
    public List<StaffDTO> getAllStaff() {
        return staffService.getAllStaff();
    }

    /**
     * <p> Update an existing staff member. </p>
     *
     * @param id <p> Staff ID to update. </p>
     * @param staffDTO <p> New data for the staff. </p>
     * @return <p> true if updated successfully, false otherwise. </p>
     */
    @PutMapping("/update/{id}")
    public boolean updateStaff(@PathVariable String id, @RequestBody StaffDTO staffDTO) {
        return staffService.updateStaff(
                id,
                staffDTO.getName(),
                staffDTO.getSalary(),
                staffDTO.getEmail(),
                staffDTO.getPhoneNumber(),
                staffDTO.getPosition(),
                staffDTO.getDepartmentId()
        );
    }

    /**
     * <p> Delete a staff member by ID. </p>
     *
     * @param id <p> Staff ID. </p>
     * @return <p> true if deleted successfully, false otherwise. </p>
     */
    @DeleteMapping("/delete/{id}")
    public boolean deleteStaff(@PathVariable String id) {
        return staffService.deleteStaff(id);
    }

    /**
     * <p> Get staff members by department ID. </p>
     *
     * @param departmentId <p> Department ID. </p>
     * @return <p> List of StaffDTOs belonging to the given department. </p>
     */
    @GetMapping("/department/{departmentId}")
    public List<StaffDTO> getStaffByDepartment(@PathVariable int departmentId) {
        return staffService.getStaffByDepartment(departmentId);
    }
}
