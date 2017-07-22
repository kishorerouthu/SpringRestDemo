package com.css.spring.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.css.spring.rest.model.Employee;
import com.css.spring.rest.service.EmployeeService;
import com.css.spring.rest.util.StringWrapper;

import static com.css.spring.rest.util.StringWrapper.SUCCESS_RESPONSE;

/**
 * @author Kishore Routhu on 22/7/17 8:55 PM.
 */
@RestController
@RequestMapping(path = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @RequestMapping(path = "/{empId}", method = RequestMethod.PUT)
    public StringWrapper updateEmployee(@PathVariable("empId") Long empId, @RequestBody Employee employee) {
        employeeService.updateEmployee(empId, employee);
        return SUCCESS_RESPONSE;
    }

    @RequestMapping(path = "/{empId}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable("empId") Long empId) {
        return employeeService.getEmployee(empId);
    }

    @RequestMapping(path = "/{empId}", method = RequestMethod.DELETE)
    public StringWrapper deleteEmployee(@PathVariable("empId") Long empId) {
        employeeService.deleteEmployee(empId);
        return SUCCESS_RESPONSE;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
