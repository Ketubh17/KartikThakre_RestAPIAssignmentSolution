package com.empmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empmanagement.entity.Emp;



public interface EmpRepository  extends JpaRepository<Emp, Integer>{

    @Query("SELECT e FROM Employee e WHERE LOWER(e.firstname) LIKE %:firstname%")
    List<Emp> findEmployeeByFirstname(@Param("firstname") String firstname);


    List<Emp> findAllByOrderByFirstnameAsc();

    List<Emp> findAllByOrderByFirstnameDesc();
}
