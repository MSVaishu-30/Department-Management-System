package com.deptmanagement.sys.services.serviceprovider;

import com.deptmanagement.sys.domain.entity.DepartmentEntity;
import com.deptmanagement.sys.domain.entity.StudentEntity;
import com.deptmanagement.sys.dto.StudentDTO;
import com.deptmanagement.sys.exception.EntityNotFoundException;
import com.deptmanagement.sys.mapper.StudentMapper;
import com.deptmanagement.sys.repository.DepartmentRepository;
import com.deptmanagement.sys.repository.StudentRepository;
import com.deptmanagement.sys.services.IStudentService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <p> Implements student-related business logic and interacts with the repository layer. </p>
 */
@Service
public class StudentServices implements IStudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServices.class);

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final StudentMapper studentMapper;

    /**
     * <p> Constructor for Dependency Injection of Student Repository and Mapper. </p>
     *
     * @param studentRepository <p> Repository for student operations. </p>
     * @param departmentRepository <p> Repository for department operations. </p>
     * @param studentMapper <p> Mapper for converting between DTO and Entity. </p>
     */
    @Autowired
    public StudentServices(StudentRepository studentRepository,
                           DepartmentRepository departmentRepository,
                           StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.studentMapper = studentMapper;
    }

    /**
     * <p> Adds a new student to the database. </p>
     *
     * @param studentDTO <p> The DTO containing student details. </p>
     * @return <p> true if student is added successfully, false if USN already exists. </p>
     */
    @Override
    @Transactional
    public boolean addStudent(StudentDTO studentDTO) {
        if (studentRepository.existsById(studentDTO.getUsn())) {
            throw new EntityNotFoundException("Student USN " + studentDTO.getUsn() + " already exists!");
        }

        Optional<DepartmentEntity> departmentOpt = departmentRepository.findById(studentDTO.getDepartmentId());
        if (departmentOpt.isEmpty()) {
            throw new EntityNotFoundException("Department ID " + studentDTO.getDepartmentId() + " not found!");
        }

        StudentEntity studentEntity = studentMapper.toEntity(studentDTO);
        studentEntity.setDepartment(departmentOpt.get());

        studentRepository.save(studentEntity);
        logger.info("Student added: {}", studentEntity);
        return true;
    }

    /**
     * <p> Retrieves all students from the database. </p>
     *
     * @return <p> List of all students as DTOs. </p>
     */
    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        return studentMapper.toDTOList(studentEntities);
    }

    /**
     * <p> Updates the name of an existing student. </p>
     *
     * @param usn <p> The unique USN of the student. </p>
     * @param newName <p> The new name to be assigned to the student. </p>
     */
    @Override
    public void updateStudent(String usn, String newName) {
        Optional<StudentEntity> studentOpt = studentRepository.findById(usn);
        if (studentOpt.isPresent()) {
            StudentEntity student = studentOpt.get();
            student.setName(newName);
            studentRepository.save(student);
            logger.info("Student updated: USN={}, New Name={}", usn, newName);
        } else {
            logger.warn("Student not found: USN={}", usn);
        }
    }

    /**
     * <p> Deletes a student by USN. </p>
     *
     * @param usn <p> The unique USN of the student. </p>
     */
    @Override
    @Transactional
    public void deleteStudent(String usn) {
        if (studentRepository.existsById(usn)) {
            studentRepository.deleteById(usn);
            logger.info("Student deleted: USN={}", usn);
        } else {
            logger.warn("Student not found: USN={}", usn);
        }
    }

    /**
     * <p> Retrieves a student by USN. </p>
     *
     * @param usn <p> The unique USN of the student. </p>
     * @return <p> The student entity if found, otherwise null. </p>
     */
    @Override
    public StudentEntity getStudentByUsn(String usn) {
        Optional<StudentEntity> student = studentRepository.findById(usn);
        if (student.isPresent()) {
            logger.info("Retrieved student: {}", student.get());
            return student.get();
        } else {
            logger.warn("Student not found with USN: {}", usn);
            return null;
        }
    }

    /**
     * <p> Retrieves all students belonging to a specific department. </p>
     *
     * @param departmentId <p> The department ID. </p>
     * @return <p> List of students in the department as DTOs. </p>
     */
    @Override
    public List<StudentDTO> getStudentsByDepartment(int departmentId) {
        List<StudentEntity> students = studentRepository.findByDepartment_DeptId(departmentId);
        if (students.isEmpty()) {
            logger.info("No students found in department ID: {}", departmentId);
        } else {
            logger.info("Retrieved {} students from department ID: {}", students.size(), departmentId);
        }

        List<StudentDTO> studentDTOs = new ArrayList<>();
        for (StudentEntity student : students) {
            studentDTOs.add(studentMapper.toDTO(student));
        }
        return studentDTOs;
    }
}
