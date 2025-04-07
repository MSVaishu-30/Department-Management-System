package com.deptmanagement.sys.controller;

import com.deptmanagement.sys.domain.entity.DepartmentEntity;
import com.deptmanagement.sys.dto.StudentDTO;
import com.deptmanagement.sys.services.IDepartmentService;
import com.deptmanagement.sys.services.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

/**
 * <p> REST controller for managing department-related operations. </p>
 */
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private final IDepartmentService departmentService;
    private final IStudentService studentService;

    /**
     * <p> Constructor for injecting department and student services. </p>
     *
     * @param departmentService <p> Service to manage department operations. </p>
     * @param studentService <p> Service to manage student operations. </p>
     */
    public DepartmentController(IDepartmentService departmentService, IStudentService studentService) {
        this.departmentService = departmentService;
        this.studentService = studentService;
    }

    /**
     * <p> Get all departments. </p>
     *
     * @return <p> List of all departments. </p>
     */
    @GetMapping
    public ResponseEntity<List<DepartmentEntity>> getAllDepartments() {
        return ok(departmentService.getAllDepartments());
    }

    /**
     * <p> Get a department by its ID. </p>
     *
     * @param id <p> Department ID. </p>
     * @return <p> DepartmentEntity if found, 404 otherwise. </p>
     */
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentEntity> getDepartmentById(@PathVariable Integer id) {
        DepartmentEntity department = departmentService.getDepartmentById(id);
        return department != null ? ok(department) : ResponseEntity.notFound().build();
    }

    /**
     * <p> Add a new department. </p>
     *
     * @param department <p> DepartmentEntity object to be added. </p>
     * @return <p> Success message. </p>
     */
    @PostMapping
    public ResponseEntity<String> addDepartment(@RequestBody DepartmentEntity department) {
        departmentService.addDepartment(department.getDeptId(), department.getName());
        return ok("Department added successfully!");
    }

    /**
     * <p> Update an existing department. </p>
     *
     * @param id <p> Department ID. </p>
     * @param department <p> Updated department data. </p>
     * @return <p> Success message. </p>
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentEntity department) {
        departmentService.updateDepartment(id, department.getName());
        return ok("Department updated successfully!");
    }

    /**
     * <p> Delete a department by ID. </p>
     *
     * @param id <p> Department ID. </p>
     * @return <p> Success message. </p>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
        return ok("Department deleted successfully!");
    }

    /**
     * <p> Get all students belonging to a department. </p>
     *
     * @param deptId <p> Department ID. </p>
     * @return <p> List of StudentDTOs. </p>
     */
    @GetMapping("/{deptId}/students")
    public ResponseEntity<List<StudentDTO>> getStudentsByDepartment(@PathVariable Integer deptId) {
        return ResponseEntity.ok(studentService.getStudentsByDepartment(deptId));
    }
}
