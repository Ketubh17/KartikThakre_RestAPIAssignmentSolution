package com.empmanagement.service;

import java.util.List;

import com.empmanagement.entity.Emp;
import com.empmanagement.entity.Roles;
import com.empmanagement.entity.Users;


public interface EmpService {
	
	 	public List<Emp> findAllEmployees();

	    public Emp findEmployeeById(int id);

	    public void saveEmployee(Emp emp);

	    public void deleteEmployeeById(int id);

	    public List<Emp> searchEmployeeByFirstName(String firstName);

	    public List<Emp> sortEmployeeByOrder(String order);

	    public Users saveUser(Users user);

	    public Roles saveRole(Roles role);
}
