package pro.sky.skypro.spring28.API;

import java.util.Objects;

public class Employee {
    private final String passport;
    private final String firstName;
    private final String lastName;
    private final int salary;
    private final int departmentId;

    public Employee(String passport, String firstName, String lastName, int salary, int departmentId) {
        this.passport = passport;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getPassport() {
        return passport; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary; }

    public int getDepartmentId() {
        return departmentId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && departmentId == employee.departmentId && Objects.equals(passport, employee.passport) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport, firstName, lastName, salary, departmentId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "passport='" + passport + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                '}';
    }
}