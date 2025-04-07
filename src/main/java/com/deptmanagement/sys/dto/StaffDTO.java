package com.deptmanagement.sys.dto;

/**
 * <p> Data Transfer Object (DTO) for Staff. </p>
 * <p> Used to send staff data in API responses. </p>
 */
public class StaffDTO {

    /**
     * <p> Unique staff ID. </p>
     */
    private String id;

    /**
     * <p> Staff member's name. </p>
     */
    private String name;

    /**
     * <p> Staff salary. </p>
     */
    private double salary;

    /**
     * <p> Staff email address. </p>
     */
    private String email;

    /**
     * <p> Staff phone number. </p>
     */
    private String phoneNumber;

    /**
     * <p> Staff position or role. </p>
     */
    private String position;

    /**
     * <p> Associated department ID. </p>
     */
    private int departmentId;

    /**
     * <p> Default constructor. </p>
     */
    public StaffDTO() {}

    /**
     * <p> Parameterized constructor. </p>
     *
     * @param id <p> Staff ID. </p>
     * @param name <p> Staff name. </p>
     * @param salary <p> Staff salary. </p>
     * @param email <p> Staff email. </p>
     * @param phoneNumber <p> Staff phone number. </p>
     * @param position <p> Staff position. </p>
     * @param departmentId <p> Department ID. </p>
     */
    public StaffDTO(String id, String name, double salary, String email, String phoneNumber, String position, int departmentId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.departmentId = departmentId;
    }

    /**
     * <p> Gets the staff ID. </p>
     * @return <p> Staff ID. </p>
     */
    public String getId() { return id; }

    /**
     * <p> Gets the staff name. </p>
     * @return <p> Staff name. </p>
     */
    public String getName() { return name; }

    /**
     * <p> Gets the staff salary. </p>
     * @return <p> Staff salary. </p>
     */
    public double getSalary() { return salary; }

    /**
     * <p> Gets the staff email. </p>
     * @return <p> Staff email. </p>
     */
    public String getEmail() { return email; }

    /**
     * <p> Gets the staff phone number. </p>
     * @return <p> Staff phone number. </p>
     */
    public String getPhoneNumber() { return phoneNumber; }

    /**
     * <p> Gets the staff position. </p>
     * @return <p> Staff position. </p>
     */
    public String getPosition() { return position; }

    /**
     * <p> Gets the associated department ID. </p>
     * @return <p> Department ID. </p>
     */
    public int getDepartmentId() { return departmentId; }

    /**
     * <p> Sets the staff ID. </p>
     * @param id <p> Staff ID. </p>
     */
    public void setId(String id) { this.id = id; }

    /**
     * <p> Sets the staff name. </p>
     * @param name <p> Staff name. </p>
     */
    public void setName(String name) { this.name = name; }

    /**
     * <p> Sets the staff salary. </p>
     * @param salary <p> Staff salary. </p>
     */
    public void setSalary(double salary) { this.salary = salary; }

    /**
     * <p> Sets the staff email. </p>
     * @param email <p> Staff email. </p>
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * <p> Sets the staff phone number. </p>
     * @param phoneNumber <p> Staff phone number. </p>
     */
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    /**
     * <p> Sets the staff position. </p>
     * @param position <p> Staff position. </p>
     */
    public void setPosition(String position) { this.position = position; }

    /**
     * <p> Sets the department ID. </p>
     * @param departmentId <p> Department ID. </p>
     */
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }
}
