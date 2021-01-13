package com.example.resttemplate.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resttemplate.vo.testVO;

@RestController
public class MainApi {
	
	@GetMapping("test/{id}")
	public String getTestVO(@PathVariable long id) {
		return testVO.builder().id(id)
				.age(23)
				.name("testName")
				.toString();
	}

}
