package com.example.resttemplate.api;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(MainApi.class)
class MainApiTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
	}
	
	@Test
	void test1() {
		assertTrue(true);
		
	}
	
	
	@Test
	void test() throws Exception {
		
		RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/test/14").contentType(org.springframework.http.MediaType.APPLICATION_JSON);
		mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());
				
	}

}
