package com.deptmanagement.sys.services.serviceprovider;

import com.deptmanagement.sys.dto.StudentDTO;
import com.deptmanagement.sys.mapper.StudentMapper;
import com.deptmanagement.sys.repository.DepartmentRepository;
import com.deptmanagement.sys.repository.StudentRepository;
import com.deptmanagement.sys.domain.entity.DepartmentEntity;
import com.deptmanagement.sys.domain.entity.StudentEntity;
import com.deptmanagement.sys.services.IDepartmentService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p> Implements department-related business logic and interacts with the repository layer. </p>
 */
@Service
public class DepartmentServices implements IDepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentServices.class);

    private final DepartmentRepository departmentRepository;
    private final StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    /**
     * <p> Constructor to initialize repositories for department and student operations using Spring Dependency Injection. </p>
     *
     * @param departmentRepository <p> Repository for department operations. </p>
     * @param studentRepository    <p> Repository for student operations. </p>
     */
    @Autowired
    public DepartmentServices(DepartmentRepository departmentRepository, StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    /**
     * <p> Adds a new department to the database. </p>
     *
     * @param deptId <p> The unique ID of the department. </p>
     * @param name   <p> The name of the department. </p>
     */
    @Override
    public void addDepartment(Integer deptId, String name) {
        logger.info("Adding department: ID={} Name={}", deptId, name);
        departmentRepository.save(new DepartmentEntity(deptId, name));
        logger.info("Department added successfully: ID={}", deptId);
    }

    /**
     * <p> Retrieves all departments from the database. </p>
     *
     * @return <p> A list of all department entities. </p>
     */
    @Override
    public List<DepartmentEntity> getAllDepartments() {
        logger.info("Fetching all departments...");
        List<DepartmentEntity> departments = departmentRepository.findAll();
        logger.info("Total departments retrieved: {}", departments.size());
        return departments;
    }

    /**
     * <p> Retrieves a department by its ID from the database. </p>
     *
     * @param deptId <p> The unique department ID. </p>
     * @return <p> The department entity if found, otherwise null. </p>
     */
    @Override
    public DepartmentEntity getDepartmentById(Integer deptId) {
        logger.info("Fetching department with ID={}", deptId);
        Optional<DepartmentEntity> department = departmentRepository.findById(deptId);
        if (department.isEmpty()) {
            logger.warn("Department not found: ID={}", deptId);
            return null;
        }
        logger.info("Department found: {}", department.get().getName());
        return department.get();
    }

    /**
     * <p> Updates the name of a department in the database. </p>
     *
     * @param deptId  <p> The unique department ID. </p>
     * @param newName <p> The new name to be assigned to the department. </p>
     */
    @Override
    public void updateDepartment(Integer deptId, String newName) {
        logger.info("Updating department: ID={} New Name={}", deptId, newName);
        Optional<DepartmentEntity> departmentOpt = departmentRepository.findById(deptId);
        if (departmentOpt.isPresent()) {
            DepartmentEntity department = departmentOpt.get();
            department.setName(newName);
            departmentRepository.save(department);
            logger.info("Department updated successfully: ID={}", deptId);
        } else {
            logger.warn("Department not found: ID={}", deptId);
        }
    }

    /**
     * <p> Deletes a department from the database along with its associated students. </p>
     *
     * @param deptId <p> The unique department ID. </p>
     */
    @Override
    @Transactional
    public void deleteDepartment(Integer deptId) {
        logger.info("Deleting department with ID={}", deptId);

        // Delete students first
        List<StudentEntity> students = studentRepository.findByDepartment_DeptId(deptId);
        studentRepository.deleteAll(students);

        // Delete department
        departmentRepository.deleteById(deptId);
        logger.info("Department deleted successfully: ID={}", deptId);
    }

    /**
     * <p> Retrieves and converts students belonging to a specific department. </p>
     *
     * @param deptId <p> The unique department ID. </p>
     * @return <p> List of StudentDTOs in the specified department. </p>
     */
    @Override
    public List<StudentDTO> getStudentsByDepartment(Integer deptId) {
        logger.info("Fetching students for department ID={}", deptId);
        List<StudentEntity> students = studentRepository.findByDepartment_DeptId(deptId);
        return students.stream()
                .map(studentMapper::toDTO)
                .toList();
    }
}
