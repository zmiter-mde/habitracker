package com.mde.test.controller;

import com.mde.test.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zmiter on 4/8/16.
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    static List<Employee> employees = new LinkedList<>();
    static {
        employees.add(new Employee(1, "First", 1000d));
        employees.add(new Employee(2, "Second", 2000d));
        employees.add(new Employee(3, "Third", 3000d));
    }

    @RequestMapping(value = "/{id}",
                    method = RequestMethod.GET)
    @ResponseBody
    public Employee findById(@PathVariable Integer id) {
        Employee res = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                res = employee;
            }
        }
        return res;
    }
}
