package com.green.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
	
import com.green.dto.UserDto;
import com.green.entity.User;
	import com.green.repository.UserRepository;

	import lombok.RequiredArgsConstructor;

	@RequiredArgsConstructor
	@Service
	public class UserService {

	    private final UserRepository userRepository;
	    private final BCryptPasswordEncoder bCryptPasswordEncoder;
           //save()" db insert
	    public Long save(UserDto dto) {
	        return userRepository.save(User.builder()   //빌더 패턴
	                .email(dto.getEmail())
	                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
	                .build()).getId();
	    }
	}

