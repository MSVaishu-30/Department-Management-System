package com.deptmanagement.sys.domain.entity;

import jakarta.persistence.*;

/**
 * <p> Represents a student entity with USN, name, and department ID. </p>
 */
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @Column(name = "usn", nullable = false, unique = true, length = 10)
    private String usn;  // Unique Student Number

    @Column(name = "name", nullable = false)
    private String name; // Student's name

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private DepartmentEntity department; // The department the student belongs to

    /**
     * <p> Default constructor. </p>
     */
    public StudentEntity() {}

    /**
     * <p> Constructor to initialize the student with USN, name, and department. </p>
     *
     * @param usn        The unique student number.
     * @param name       The name of the student.
     * @param department The department the student belongs to.
     */
    public StudentEntity(String usn, String name, DepartmentEntity department) {
        this.usn = usn;
        this.name = name;
        this.department = department;
    }

    /**
     * <p> Retrieves the student's USN. </p>
     *
     * @return The USN of the student.
     */
    public String getUsn() {
        return usn;
    }

    /**
     * <p> Sets the student's USN. </p>
     *
     * @param usn The USN to set.
     */
    public void setUsn(String usn) {
        this.usn = usn;
    }

    /**
     * <p> Retrieves the student's name. </p>
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * <p> Sets the student's name. </p>
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p> Retrieves the department the student belongs to. </p>
     *
     * @return The department entity.
     */
    public DepartmentEntity getDepartment() {
        return department;
    }

    /**
     * <p> Sets the department for the student. </p>
     *
     * @param department The department to set.
     */
    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }



    /**
     * <p> Returns a string representation of the StudentEntity object. </p>
     *
     * @return A string containing student details.
     */
    @Override
    public String toString() {
        return "StudentEntity{" +
                "usn='" + usn + '\'' +
                ", name='" + name + '\'' +
                ", department=" + (department != null ? department.getName() : "None") +
                '}';
    }
}
