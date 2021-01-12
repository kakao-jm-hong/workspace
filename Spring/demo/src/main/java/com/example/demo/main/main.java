package com.example.demo.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RedbinService;

@RestController
public class main {

	
	private static final Logger logger = LoggerFactory.getLogger(RedbinService.class);
	
//	public main() {
//		redbinService = new RedbinService();
//	}
	@Autowired
	RedbinService redbinService;
	
	@GetMapping
	public String test() {
		logger.info("실행전");
		try {
			redbinService.method1(123);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("실행후");

		return Math.random()*1000 +"";
	}

}
