package pro.sky.skypro.spring28.API.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skypro.spring28.API.API.EmployeeServiceSalary;
import pro.sky.skypro.spring28.API.Employee;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class EmployeeControllerSalary {
    private final EmployeeServiceSalary employeeServiceSalary;

    public EmployeeControllerSalary(EmployeeServiceSalary employeeServiceSalary) {
        this.employeeServiceSalary = employeeServiceSalary;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary (@RequestParam("departmentId") int departmentId) {
        return employeeServiceSalary.maxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary (@RequestParam("departmentId") int departmentId) {
        return employeeServiceSalary.minSalary(departmentId);
    }

    @GetMapping(path = "/all", params = "departmentId")
    public List<Employee> allEmployeesOfDepartment (@RequestParam("departmentId") int departmentId) {
        return employeeServiceSalary.allEmployeesOfDepartment(departmentId);
    }

    @GetMapping(path = "/all")
    public List<Employee> allEmployeesByDepartments () {
        return employeeServiceSalary.allEmployeesByDepartments();
    }
}
