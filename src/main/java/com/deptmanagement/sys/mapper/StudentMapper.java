package com.deptmanagement.sys.mapper;

import com.deptmanagement.sys.domain.entity.StudentEntity;
import com.deptmanagement.sys.dto.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Utility class for converting StudentEntity to StudentDTO and vice versa. </p>
 */
@Component
public class StudentMapper {

    /**
     * <p> Converts StudentDTO to StudentEntity. </p>
     *
     * @param studentDTO <p> The DTO object. </p>
     * @return <p> Corresponding StudentEntity. </p>
     */
    public StudentEntity toEntity(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }
        return new StudentEntity(
                studentDTO.getUsn(),
                studentDTO.getName(),
                null // Department will be set separately
        );
    }

    /**
     * <p> Converts StudentEntity to StudentDTO. </p>
     *
     * @param entity <p> The entity object. </p>
     * @return <p> Corresponding StudentDTO. </p>
     */
    public StudentDTO toDTO(StudentEntity entity) {
        if (entity == null) {
            return null;
        }
        return new StudentDTO(
                entity.getUsn(),
                entity.getName(),
                entity.getDepartment().getDeptId()
        );
    }

    /**
     * <p> Converts a list of StudentEntity objects to a list of StudentDTOs. </p>
     *
     * @param entities <p> List of StudentEntity objects. </p>
     * @return <p> List of StudentDTO objects. </p>
     */
    public List<StudentDTO> toDTOList(List<StudentEntity> entities) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (StudentEntity entity : entities) {
            studentDTOList.add(toDTO(entity));
        }
        return studentDTOList;
    }
}
