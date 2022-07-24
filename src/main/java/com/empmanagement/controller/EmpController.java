package com.empmanagement.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empmanagement.entity.Emp;
import com.empmanagement.entity.Roles;
import com.empmanagement.entity.Users;
import com.empmanagement.service.EmpService;


@RestController
public class EmpController {
	
	
    private EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @PostMapping("/user")
    public Users saveUser(@RequestBody Users user) {
        return empService.saveUser(user);
    }

    @PostMapping("/role")
    public Roles saveRole(@RequestBody Roles role) {
        return empService.saveRole(role);
    }

    @GetMapping("/employees")
    public List<Emp> findAllEmployees() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
        System.out.println(currentPrincipalName);
        return empService.findAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Emp getEmployee(@PathVariable int employeeId) {
        return empService.findEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Emp saveEmployee(@RequestBody Emp emp) {
        emp.setId(0);
        empService.saveEmployee(emp);
        return emp;
    }

    @PutMapping("/employees")
    public Emp updateEmployee(@RequestBody Emp emp ) {
        empService.saveEmployee(emp);
        return emp;
    }
    
 
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        empService.deleteEmployeeById(employeeId);
        return "Employee details with id - " + employeeId + " deleted";
    }

    @GetMapping("/employees/search/{firstName}")
    public List<Emp> searchEmployeesByFirstName(@PathVariable String firstName) {
        return empService.searchEmployeeByFirstName(firstName);
    }

    @GetMapping("/employees/sort")
    public List<Emp> sortEmployeesInOrder(@RequestParam("order") String order) {
        return empService.sortEmployeeByOrder(order);
    }
}
