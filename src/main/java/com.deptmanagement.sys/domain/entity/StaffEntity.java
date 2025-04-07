package com.deptmanagement.sys.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a staff member in the department management system.
 */
@Document(collection = "staff")
public class StaffEntity {

    @Id
    private String id; // MongoDB uses String for _id
    private String name;
    private double salary;
    private String email;
    private String phoneNumber;
    private String position;
    private int departmentId;

    public StaffEntity() {}

    /**
     * Constructor to initialize a StaffEntity object.
     *
     * @param id           the unique ID of the staff member.
     * @param name         the name of the staff member.
     * @param salary       the salary of the staff member.
     * @param email        the email of the staff member.
     * @param phoneNumber  the phone number of the staff member.
     * @param position     the job position of the staff member.
     * @param departmentId the ID of the department the staff belongs to.
     */
    public StaffEntity(String id, String name, double salary, String email, String phoneNumber, String position, int departmentId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.departmentId = departmentId;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getPosition() { return position; }
    public int getDepartmentId() { return departmentId; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setPosition(String position) { this.position = position; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    @Override
    public String toString() {
        return "StaffEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", position='" + position + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
