package com.deptmanagement.sys.services;

import com.deptmanagement.sys.domain.entity.StudentEntity;
import com.deptmanagement.sys.dto.StudentDTO;
import java.util.List;

/**
 * <p> Interface defining student-related operations. </p>
 */
public interface IStudentService {



    /**
     * <p> Adds a new student to the system. </p>
     *
     * @param studentDTO The DTO containing student details.
     * @return true if the student is successfully added, false if the USN already exists.
     */
    boolean addStudent(StudentDTO studentDTO);

    /**
     * <p> Retrieves a list of all students in the system. </p>
     *
     * @return A list of student DTOs.
     */
    List<StudentDTO> getAllStudents();

    /**
     * <p> Updates the name of an existing student. </p>
     *
     * @param usn     The unique student ID.
     * @param newName The new name for the student.
     */
    void updateStudent(String usn, String newName);

    /**
     * <p> Deletes a student from the system. </p>
     *
     * @param usn The unique student ID.
     */
    void deleteStudent(String usn);

    /**
     * <p> Retrieves a student by their USN. </p>
     *
     * @param usn The unique student ID.
     * @return The student DTO if found, otherwise null.
     */
    StudentEntity getStudentByUsn(String usn);


    /**
     * <p> Retrieves all students belonging to a specific department. </p>
     *
     * @param departmentId The unique department ID.
     * @return A list of student DTOs in the given department.
     */
    List<StudentDTO> getStudentsByDepartment(int departmentId);
}
