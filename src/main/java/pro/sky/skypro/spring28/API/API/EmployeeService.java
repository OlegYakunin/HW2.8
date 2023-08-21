package pro.sky.skypro.spring28.API.API;

import pro.sky.skypro.spring28.API.Employee;

import java.util.Collection;


public interface EmployeeService {
    Employee addEmployee(String passport, String firstName, String lastName, int salary, int department);
    Employee removeEmployee(String passport, String firstName, String lastName, int salary, int department);
    Employee findEmployee(String passport, String firstName, String lastName, int salary, int department);

    Collection<Employee> returnMapEmployees();
}

