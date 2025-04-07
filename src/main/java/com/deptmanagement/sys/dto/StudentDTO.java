package com.deptmanagement.sys.dto;

/**
 * <p> Data Transfer Object for Student. </p>
 */
public class StudentDTO {

    /**
     * <p> Unique Student USN (University Serial Number). </p>
     */
    private String usn;

    /**
     * <p> Name of the student. </p>
     */
    private String name;

    /**
     * <p> ID of the department the student belongs to. </p>
     */
    private Integer departmentId;

    /**
     * <p> Parameterized constructor. </p>
     *
     * @param usn <p> Student USN. </p>
     * @param name <p> Student name. </p>
     * @param departmentId <p> Department ID. </p>
     */
    public StudentDTO(String usn, String name, Integer departmentId) {
        this.usn = usn;
        this.name = name;
        this.departmentId = departmentId;
    }

    /**
     * <p> Gets the student USN. </p>
     *
     * @return <p> Student USN. </p>
     */
    public String getUsn() {
        return usn;
    }

    /**
     * <p> Gets the student name. </p>
     *
     * @return <p> Student name. </p>
     */
    public String getName() {
        return name;
    }

    /**
     * <p> Gets the department ID. </p>
     *
     * @return <p> Department ID. </p>
     */
    public Integer getDepartmentId() {
        return departmentId;
    }
}
