package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.entity.SysUser;

@Component
public class CustomUserService implements UserDetailsService{

	 @Autowired
	 SysUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
	}

}