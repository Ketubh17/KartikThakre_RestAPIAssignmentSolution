package com.empmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.empmanagement.entity.Emp;
import com.empmanagement.entity.Roles;
import com.empmanagement.entity.Users;
import com.empmanagement.repository.EmpRepository;
import com.empmanagement.repository.RoleRepository;
import com.empmanagement.repository.UserRepository;



public class EmpServiceImpl implements EmpService{
	
	private EmpRepository empRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    @Autowired
    public EmpServiceImpl(EmpRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public List<Emp> findAllEmployees() {
        return empRepository.findAll();
    }

    @Override
    public Emp findEmployeeById(int id) {

       Optional<Emp> empOptional = empRepository.findById(id);

        if (empOptional.isEmpty()) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }

        Emp foundEmp =  empOptional.get();
        return foundEmp;
    }

    @Override
    public void saveEmployee(Emp emp) {
        empRepository.save(emp);
    }

    @Override
    public void deleteEmployeeById(int id) {
        empRepository.deleteById(id);
    }

    @Override
    public List<Emp> searchEmployeeByFirstName(String firstName) {
        return empRepository.findEmployeeByFirstname(firstName.toLowerCase());
    }

    @Override
    public List<Emp> sortEmployeeByOrder(String order) {

        List<Emp> employees = null;

        if (order.toLowerCase().equals("asc")) {
            employees = empRepository.findAllByOrderByFirstnameAsc();
        } else if (order.toLowerCase().equals("desc")) {
            employees = empRepository.findAllByOrderByFirstnameDesc();
        } else {
            throw new RuntimeException("No proper order mentioned");
        }
        return employees;
    }

    @Override
    public Users saveUser(Users user) {
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Roles saveRole(Roles role) {
        return roleRepository.save(role);
    }

}
