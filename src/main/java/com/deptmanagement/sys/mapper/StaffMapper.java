package com.deptmanagement.sys.mapper;

import com.deptmanagement.sys.domain.entity.StaffEntity;
import com.deptmanagement.sys.dto.StaffDTO;
import org.springframework.stereotype.Component;

/**
 * <p> Mapper class for Staff. </p>
 * <p> Converts between StaffEntity and StaffDTO. </p>
 */
@Component
public class StaffMapper {

    /**
     * <p> Converts StaffEntity to StaffDTO. </p>
     *
     * @param staff <p> The StaffEntity object. </p>
     * @return <p> Corresponding StaffDTO object. </p>
     */
    public StaffDTO toDTO(StaffEntity staff) {
        if (staff == null) return null;
        return new StaffDTO(
                staff.getId(),
                staff.getName(),
                staff.getSalary(),
                staff.getEmail(),
                staff.getPhoneNumber(),
                staff.getPosition(),
                staff.getDepartmentId()
        );
    }

    /**
     * <p> Converts StaffDTO to StaffEntity. </p>
     *
     * @param staffDTO <p> The StaffDTO object. </p>
     * @return <p> Corresponding StaffEntity object. </p>
     */
    public StaffEntity toEntity(StaffDTO staffDTO) {
        if (staffDTO == null) return null;
        return new StaffEntity(
                staffDTO.getId(),
                staffDTO.getName(),
                staffDTO.getSalary(),
                staffDTO.getEmail(),
                staffDTO.getPhoneNumber(),
                staffDTO.getPosition(),
                staffDTO.getDepartmentId()
        );
    }
}
