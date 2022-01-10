package se.yrgo.employee.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import se.yrgo.employee.entities.Employee;
import se.yrgo.employee.entities.enums.EmployeeStatus;
import se.yrgo.employee.entities.enums.SystemStatus;

public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    // Mandatory fields
    private String userId;
    private String firstName;
    private String lastName;
    private String personalNumber;
    private String email;
    private String phoneNumber;
    private String street;
    private String zip;
    private String city;
    private String jobTitle;
    private LocalDate startDate;
    // Optional fields
    private String parentCompany;
    private LocalDate endDate;
    private EmployeeStatus employeeStatus;
    private SystemStatus systemStatus;
    // private String imageURL;

    // , String imageURL
    public EmployeeDTO(
        String firstName,
        String lastName,
        String personalNumber,
        String email,
        String phoneNumber,
        String street,
        String zip,
        String city,
        String jobTitle,
        String parentCompany,
        LocalDate startDate,
        LocalDate endDate,
        EmployeeStatus employeeStatus,
        SystemStatus systemStatus
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
        setEmail(email);
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.jobTitle = jobTitle;
        this.parentCompany = parentCompany;
        this.startDate = startDate;
        this.endDate = endDate;
        // this.imageURL = imageURL;
        setEmployeeStatus(employeeStatus);
        setSystemStatus(systemStatus);
    }

    public EmployeeDTO(Employee employee) {
        this(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPersonalNumber(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getStreet(),
                employee.getZip(),
                employee.getCity(),
                employee.getJobTitle(),
                employee.getParentCompany(),
                employee.getStartDate(),
                employee.getEndDate(),
                employee.getEmployeeStatus(),
                employee.getSystemStatus()
        );
        this.userId = employee.getUserId();
    }

    public String generateName() {
        String sb = firstName.substring(0, 3) + lastName.substring(0, 3);
        return sb.toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return Objects.equals(userId, that.userId) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null){
            throw new NullPointerException("Null email value not allowed!");
        }
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(String parentCompany) {
        this.parentCompany = parentCompany;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public SystemStatus getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(SystemStatus systemStatus) {
        this.systemStatus = systemStatus;
    }

    /*
     * public String getImageURL() { return imageURL; } public void
     * setImageURL(String imageURL) { this.imageURL = imageURL; }
     */
}
