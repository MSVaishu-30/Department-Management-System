package com.deptmanagement.sys.mapper;

import com.deptmanagement.sys.domain.entity.DepartmentEntity;
import com.deptmanagement.sys.dto.DepartmentDTO;

/**
 * <p> Converts between DepartmentEntity and DepartmentDTO. </p>
 */
public class DepartmentMapper {

    /**
     * <p> Converts DepartmentEntity to DepartmentDTO. </p>
     *
     * @param department <p> The entity object to be converted. </p>
     * @return <p> Converted DepartmentDTO object. </p>
     */
    public static DepartmentDTO toDTO(DepartmentEntity department) {
        return new DepartmentDTO(department.getDeptId(), department.getName());
    }

    /**
     * <p> Converts DepartmentDTO to DepartmentEntity. </p>
     *
     * @param dto <p> The DTO object to be converted. </p>
     * @return <p> Converted DepartmentEntity object. </p>
     */
    public static DepartmentEntity toEntity(DepartmentDTO dto) {
        return new DepartmentEntity(dto.getDeptId(), dto.getName());
    }
}
