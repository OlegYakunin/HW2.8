package pro.sky.skypro.spring28.API.service;

import org.springframework.stereotype.Service;
import pro.sky.skypro.spring28.API.API.EmployeeService;
import pro.sky.skypro.spring28.API.Employee;
import pro.sky.skypro.spring28.API.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skypro.spring28.API.exceptions.EmployeeNotFoundException;
import pro.sky.skypro.spring28.API.exceptions.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int CounterEmployees = 10;
    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "1", new Employee("54531", "Егор", "Смирнов", 73633, 2),
            "2", new Employee("53523", "Павел", "Петров ", 1103461, 2),
            "3", new Employee("65466", "Александр ", "Козлов", 94456, 1),
            "4", new Employee("35464", "Ольга ", "Самушкина", 822334, 5),
            "5", new Employee("62546", "Ильф", "Коко ", 11382, 3),
            "6", new Employee("56346", "Снежанна", "Головешкина", 872583, 2),
            "7", new Employee("75436", "Нестр", "Махно ", 57346, 5),
            "8", new Employee("73457", "Ваня", "Ушаков", 63452, 2),
            "9", new Employee("73454", "Надежда", "Цветкова", 645333, 3),
            "10", new Employee("97553", "Марина", "Логинова", 440000, 3)
    ));
    public Map<String, Employee> getEmployees() { return employees; }
    @Override
    public Employee addEmployee(String passport, String firstName, String lastName, int salary, int department) {
        Employee newEmployee = new Employee(passport, firstName, lastName, salary, department);
        if (employees.containsKey(newEmployee.getPassport())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже находится в листе");
        } else if (employees.size() == CounterEmployees) {
            throw new EmployeeStorageIsFullException("Лист сотрудников переполнен");
        } else {
            employees.put(newEmployee.getPassport(), newEmployee);
            return newEmployee;
        }
    }

    @Override
    public Employee removeEmployee(String passport, String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(passport, firstName, lastName, salary, department);
        if (!employees.containsKey(employee.getPassport())) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        } else {
            return employees.remove(employee.getPassport());
        }
    }

    @Override
    public Employee findEmployee(String passport, String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(passport, firstName, lastName, salary, department);
        if (!employees.containsKey(employee.getPassport())) {
            throw new EmployeeNotFoundException("Cотрудник не найден");
        } else {
            return employees.get(employee.getPassport());
        }
    }

    @Override
    public Collection<Employee> returnMapEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}

