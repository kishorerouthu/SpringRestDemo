package com.css.spring.rest.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.spring.rest.cache.EmployeeRegistry;
import com.css.spring.rest.keygen.IDGenerator;
import com.css.spring.rest.model.Employee;

/**
 * @author Kishore Routhu on 22/7/17 9:10 PM.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRegistry registry;

    @Override
    public Employee createEmployee(Employee employee) {
        Long empId = IDGenerator.generateNewId();
        employee.setId(empId);
        registry.addEmployee(empId, employee);
        return employee;
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        employee.setId(id);
        registry.updateEmployee(id, employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return registry.getEmployee(id);
    }

    @Override
    public void deleteEmployee(Long id) {
        registry.deleteEmployee(id);
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        Collection<Employee> allEmployees = registry.getAllEmployees();
        if (allEmployees == null) {
            allEmployees = Collections.EMPTY_LIST;
        }
        return allEmployees;
    }
}
