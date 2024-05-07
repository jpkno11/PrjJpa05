package com.green.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.green.repository.UserRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor //필수입력 (not null) 항목 생성자
@Service
   
public class UserDetailService implements UserDetailsService{
	private UserRepository userRepository;
      // 로그인에 필요한 Username 로그인아이디(email) 를 통해서 
	 // UserDetail 정보를 가지고 온다
	@Override
	public UserDetails loadUserByUsername(String email) 
	    throws UsernameNotFoundException {
		UserDetails userDetails = userRepository.findByEmail(email)
				.orElseThrow(()->new IllegalArgumentException(email));
		return userDetails;
	}

}
