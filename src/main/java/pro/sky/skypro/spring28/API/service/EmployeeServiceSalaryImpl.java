package pro.sky.skypro.spring28.API.service;

import org.springframework.stereotype.Service;
import pro.sky.skypro.spring28.API.API.EmployeeService;
import pro.sky.skypro.spring28.API.API.EmployeeServiceSalary;
import pro.sky.skypro.spring28.API.Employee;
import pro.sky.skypro.spring28.API.exceptions.NoSuchElementException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceSalaryImpl implements EmployeeServiceSalary {

    private final EmployeeService employeeService;

    public EmployeeServiceSalaryImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee maxSalary(int departmentId) {
        Object NoSuchElementException;
        return employeeService.returnMapEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Employee minSalary(int departmentId) {
        Object NoSuchElementException;
        return employeeService.returnMapEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Employee> allEmployeesOfDepartment(int departmentId) {
        return employeeService.returnMapEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> allEmployeesByDepartments() {
        return employeeService.returnMapEmployees().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                .collect(Collectors.toList());
    }
}