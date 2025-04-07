package com.deptmanagement.sys.domain.entity;

import jakarta.persistence.*;

/**
 * <p> Represents a department entity with a unique ID and name. </p>
 */
@Entity
@Table(name = "department")
public class DepartmentEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates deptId
    @Column(name = "dept_id")
    private Integer deptId;  // Unique identifier for the department

    @Column(name = "name", nullable = false, unique = true)
    private String name;     // Name of the department

    /**
     * <p> Default constructor. </p>
     */
    public DepartmentEntity() {
    }

    /**
     * <p> Parameterized constructor that initializes the department with an ID and name. </p>
     *
     * @param deptId The unique ID of the department.
     * @param name   The name of the department.
     */
    public DepartmentEntity(Integer deptId, String name) {
        this.deptId = deptId;
        this.name = name;
    }

    /**
     * <p> Retrieves the department ID. </p>
     *
     * @return The department ID.
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * <p> Sets the department ID. </p>
     *
     * @param deptId The department ID to set.
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * <p> Retrieves the department name. </p>
     *
     * @return The department name.
     */
    public String getName() {
        return name;
    }

    /**
     * <p> Sets the department name. </p>
     *
     * @param name The name to set for the department.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p> Returns a string representation of the DepartmentEntity object. </p>
     *
     * @return A string containing department details.
     */
    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "deptId=" + deptId +
                ", name='" + name + '\'' +
                '}';
    }
}
