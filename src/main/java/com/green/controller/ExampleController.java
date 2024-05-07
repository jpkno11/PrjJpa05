package com.green.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Getter;
import lombok.Setter;
@Controller
public class ExampleController {
 
	@GetMapping("/thymeleaf/example")
   public String thymeleafExample(Model model) {
		Person examplePerson = new Person();
		examplePerson.setId(1L);
		examplePerson.setName("홍길동");
		examplePerson.setAge(11);
		examplePerson.setHobbies(List.of("운동","독서"));
		
		 model.addAttribute("person, examplePerson");
		 model.addAttribute("todat",LocalDate.now());
		return "example"; // exampe.html 라는 뷰조회
				
	}
  @Setter
  @Getter
   class Person{
	  
   private Long id;
   private String name;
   private int age;
   private List<String> hobbies;
}
}
