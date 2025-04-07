package com.deptmanagement.sys.services.serviceprovider;

import com.deptmanagement.sys.domain.entity.StaffEntity;
import com.deptmanagement.sys.dto.StaffDTO;
import com.deptmanagement.sys.mapper.StaffMapper;
import com.deptmanagement.sys.repository.StaffRepository;
import com.deptmanagement.sys.services.IStaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * <p> Implementation of IStaffService interface. </p>
 * <p> Provides business logic for managing staff members using MongoDB. </p>
 */
@Service
public class StaffService implements IStaffService {

    private static final Logger logger = LoggerFactory.getLogger(StaffService.class);

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    /**
     * <p> Constructor for injecting StaffRepository and StaffMapper. </p>
     *
     * @param staffRepository <p> Repository to perform CRUD operations on staff. </p>
     * @param staffMapper     <p> Mapper to convert between StaffEntity and StaffDTO. </p>
     */
    @Autowired
    public StaffService(StaffRepository staffRepository, StaffMapper staffMapper) {
        this.staffRepository = staffRepository;
        this.staffMapper = staffMapper;
    }

    /**
     * <p> Adds a new staff member with a generated UUID. </p>
     *
     * @return <p> True if added successfully. </p>
     */
    @Override
    public boolean addStaff(String name, double salary, String email, String phoneNumber, String position, int departmentId) {
        String id = UUID.randomUUID().toString(); // Generate unique ID for MongoDB
        StaffEntity staff = new StaffEntity(id, name, salary, email, phoneNumber, position, departmentId);
        staffRepository.save(staff);
        logger.info("Staff added: {}", staff);
        return true;
    }

    /**
     * <p> Retrieves staff details by ID. </p>
     *
     * @param id <p> Staff ID. </p>
     * @return <p> StaffDTO if found, else null. </p>
     */
    @Override
    public StaffDTO getStaffById(String id) {
        Optional<StaffEntity> staff = staffRepository.findById(id);
        if (staff.isPresent()) {
            logger.info("Retrieved staff: {}", staff.get());
            return staffMapper.toDTO(staff.get());
        } else {
            logger.warn("Staff not found with ID: {}", id);
            return null;
        }
    }

    /**
     * <p> Retrieves all staff members from the database. </p>
     *
     * @return <p> List of StaffDTO. </p>
     */
    @Override
    public List<StaffDTO> getAllStaff() {
        return staffRepository.findAll().stream()
                .map(staffMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * <p> Updates the details of an existing staff member. </p>
     *
     * @param id           <p> Staff ID. </p>
     * @param name         <p> Updated name. </p>
     * @param salary       <p> Updated salary. </p>
     * @param email        <p> Updated email. </p>
     * @param phoneNumber  <p> Updated phone number. </p>
     * @param position     <p> Updated position. </p>
     * @param departmentId <p> Updated department ID. </p>
     * @return <p> True if updated successfully, else false. </p>
     */
    @Override
    public boolean updateStaff(String id, String name, double salary, String email, String phoneNumber, String position, int departmentId) {
        if (staffRepository.existsById(id)) {
            StaffEntity updatedStaff = new StaffEntity(id, name, salary, email, phoneNumber, position, departmentId);
            staffRepository.save(updatedStaff);
            logger.info("Staff updated: {}", updatedStaff);
            return true;
        } else {
            logger.warn("Failed to update staff: Staff not found with ID {}", id);
            return false;
        }
    }

    /**
     * <p> Deletes a staff member by ID. </p>
     *
     * @param id <p> Staff ID. </p>
     * @return <p> True if deleted successfully, else false. </p>
     */
    @Override
    public boolean deleteStaff(String id) {
        if (staffRepository.existsById(id)) {
            staffRepository.deleteById(id);
            logger.info("Staff deleted with ID: {}", id);
            return true;
        } else {
            logger.warn("Failed to delete staff: Staff not found with ID {}", id);
            return false;
        }
    }

    /**
     * <p> Retrieves all staff members in a specific department. </p>
     *
     * @param departmentId <p> The department ID to filter staff. </p>
     * @return <p> List of StaffDTO in that department. </p>
     */
    @Override
    public List<StaffDTO> getStaffByDepartment(int departmentId) {
        List<StaffEntity> staffList = staffRepository.findByDepartmentId(departmentId);
        return staffList.stream()
                .map(staffMapper::toDTO)
                .collect(Collectors.toList());
    }

}
