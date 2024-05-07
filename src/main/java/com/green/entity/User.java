package com.green.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Table(name="usersjpa") 
// @Table : entity 는 table 명과 같지만 oracle 은 usertable명이 불가하다
// table 명을 변경해야한다 (usersjpa)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// UserDetails 인터페이스를 구현하여 user엔티티를 생성한다.
public class User implements UserDetails {
        // 칼럼부분을 표시
	   @Id // 기본키
	   @GeneratedValue(strategy=GenerationType.IDENTITY)//db정책 
	   @Column(name="id",updatable=false)
	     private Long id;
	   @Column(name="email",nullable=false,unique=true)
	     private String email;
	   @Column(name="password",nullable=false)
	     private String password;
	     //   생성자 대신 아래문법으로 사용가능 파라미터 순서 무관
	     //     @Builder
         //   User user= User.builder()
	     //                .password("aaa")
	     //                .email("aaa@aaa.com")
	     //                 .build();
	   
	   @Builder
	     public User(String email,String password) {
	    	 this.email =email;
	    	 this.password=password;
	     }
	// implement 할  메소드 
	@Override   //권한 반환
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 사용자가 가지고있는 권한의 목록을 반환 ,현재는 User 권한만 반환 
		return List.of(new SimpleGrantedAuthority("user"));
	}
      
	@Override  //사용자 비밀번호를  리턴한다. //사용자 아이디(이메일)
	public String getPassword() {
		
		return password;
	}

	@Override  ///사용자 아이디(이메일)
	public String getUsername() { // input name="username"
		
		return email;
	}

	@Override  // 계정 만료 여부 반환 
	public boolean isAccountNonExpired() {
		 // 계정이 만료되었는지를 확인하는 로직
		return true; //true -> 만료되지 않았습니다.
	}

	@Override  // 계정 잠금여부 반환
	public boolean isAccountNonLocked() {
		 // 계정 잠금 여부를 확인하는 로직
		return true; //true-> 잠금되지않음  
	}

	@Override  // 패스워드 만료 여부  반환
	public boolean isCredentialsNonExpired() {
		 //패스워드가 만료 되었는지 확인하는 로직
		return true; //true= 만료되지않음
	}

	@Override // 계정 사용 여부 반환 
	public boolean isEnabled() {
		// 계정 사용가능 여부반환하는 로직
		return true; // true  - 사용가능 
	}

 
}

