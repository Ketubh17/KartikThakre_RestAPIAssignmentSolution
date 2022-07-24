package com.empmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.empmanagement.entity.Users;
import com.empmanagement.repository.UserRepository;
import com.empmanagement.security.EmpUserDetail;




public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepository.getUserByUserName(username);

        if (user == null) {
        	throw new UsernameNotFoundException("Could not find user!!!");
        }

        return new EmpUserDetail(user);
    }
}
