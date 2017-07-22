package com.css.spring.rest.service;

import java.util.Collection;

import com.css.spring.rest.model.Employee;

/**
 * This interface defines all the operations that can be performed
 * on employees.
 *
 * @author Kishore Routhu on 22/7/17 9:10 PM.
 */
public interface EmployeeService {

    /**
     * Register new employee in organization
     * @param employee
     */
    Employee createEmployee(Employee employee);

    /**
     * Update existing employee of organization
     * @param id  existing employee id
     * @param employee updated employee data
     */
    void updateEmployee(Long id, Employee employee);

    /**
     * Finds the existing employee
     * @param id existing employee id
     * @return
     */
    Employee getEmployee(Long id);

    /**
     * delete the existign employee
     * @param id existing emplpyee id
     */
    void deleteEmployee(Long id);

    /**
     * Finds all employees of organization
     * @return collection of employee objects.
     */
    Collection<Employee> getAllEmployees();

}
