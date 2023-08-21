package pro.sky.skypro.spring28.API.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skypro.spring28.API.API.EmployeeService;
import pro.sky.skypro.spring28.API.Employee;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String passport,
                                @RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int salary,
                                @RequestParam int department) {
        return employeeService.addEmployee(passport, firstName, lastName, salary, department);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String passport,
                                   @RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam int salary,
                                   @RequestParam int department) {
        return employeeService.removeEmployee(passport, firstName, lastName, salary, department);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String passport,
                                 @RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam int salary,
                                 @RequestParam int department) {
        return employeeService.findEmployee(passport, firstName, lastName, salary, department);
    }

    @GetMapping
    public Collection<Employee> returnListEmployees() {
        return employeeService.returnMapEmployees();
    }
}
