package com.css.spring.rest.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.css.spring.rest.model.Employee;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @author Kishore Routhu on 22/7/17 8:31 PM.
 */
@Component
public class EmployeeRegistry implements DisposableBean, InitializingBean {

    private static final String dataStorageFile = "C:/Workspace/SpringRestDemo/src/main/resources/employee_data.sql";
    private static EmployeeRegistry INSTANCE = new EmployeeRegistry();

    private Cache<Long, Employee> cache = CacheBuilder.newBuilder().maximumSize(100).build();


    public static EmployeeRegistry getInstance() {
        return INSTANCE;
    }

    public void addEmployee(Long id, Employee employee) {
        updateEmployee(id, employee);
    }

    public void updateEmployee(Long id, Employee employee) {
        cache.put(id, employee);
    }

    public Employee getEmployee(Long id) {
        return cache.getIfPresent(id);
    }

    public void deleteEmployee(Long id) {
        cache.invalidate(id);
    }

    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(cache.asMap().values());
    }

    @Override
    public void destroy() throws Exception {
        persistData();
    }

    private void persistData() throws IOException {
        File file = new File(dataStorageFile);
        if (!file.exists())
            file.createNewFile();

        HashMap<Long, Employee> map = new HashMap<>(cache.asMap());
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(map);
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        File file = new File(dataStorageFile);
        if (!file.exists())
            return;

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        HashMap<Long, Employee> map = (HashMap<Long, Employee>) inputStream.readObject();
        cache.putAll(map);
        inputStream.close();

    }

    public static void main(String[] args) throws Exception {
        File file = new File(dataStorageFile);
        if (!file.exists())
            return;

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        HashMap<Long, Employee> map = (HashMap<Long, Employee>) inputStream.readObject();
        System.out.println(map);

    }
}
