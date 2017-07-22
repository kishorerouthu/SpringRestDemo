This application demonstrates the spring rest implementation.

Provides various rest end points to perform all crud operations on employee data of an organization.

API end points

1.  POST - /employees
    Enroll new employee to an organization

2.  GET -  /employees
    Retrieves all employees of an organization

3.  PUT -  /employees/{empId}
    Update an existing employee data.

4.  GET -  /employee/{empId}
    Retrieves single employee with the given empId of an organization.

5.  DELETE - /employee/{empId}
    Delete employee with the given empId of an organization.

Employee model :
    - id (long)
    - name (String)
    - age (int)
    - joinDate (date)
    - salary (double)
    - designation (String)

Data Store :
    Application stores all the data in memory. So once the application stops it will lost the data.