package com.deptmanagement.sys.dto;

/**
 * <p> Data Transfer Object for Department. </p>
 */
public class DepartmentDTO {

    /**
     * <p> Unique department ID. </p>
     */
    private Integer deptId;

    /**
     * <p> Department name. </p>
     */
    private String name;

    /**
     * <p> Default constructor. </p>
     */
    public DepartmentDTO() {}

    /**
     * <p> Parameterized constructor. </p>
     *
     * @param deptId <p> Department ID. </p>
     * @param name <p> Department name. </p>
     */
    public DepartmentDTO(Integer deptId, String name) {
        this.deptId = deptId;
        this.name = name;
    }

    /**
     * <p> Gets the department ID. </p>
     *
     * @return <p> Department ID. </p>
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * <p> Sets the department ID. </p>
     *
     * @param deptId <p> Department ID. </p>
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * <p> Gets the department name. </p>
     *
     * @return <p> Department name. </p>
     */
    public String getName() {
        return name;
    }

    /**
     * <p> Sets the department name. </p>
     *
     * @param name <p> Department name. </p>
     */
    public void setName(String name) {
        this.name = name;
    }
}

