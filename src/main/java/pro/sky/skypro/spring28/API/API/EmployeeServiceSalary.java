package pro.sky.skypro.spring28.API.API;

import pro.sky.skypro.spring28.API.Employee;

import java.util.List;

public interface EmployeeServiceSalary {
    Employee maxSalary (int departmentId);
    Employee minSalary (int departmentId);
    List<Employee> allEmployeesOfDepartment (int departmentId);
    List<Employee> allEmployeesByDepartments ();
}

