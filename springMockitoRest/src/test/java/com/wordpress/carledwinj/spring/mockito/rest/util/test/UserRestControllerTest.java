package com.wordpress.carledwinj.spring.mockito.rest.util.test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wordpress.carledwinj.spring.mockito.rest.resources.UserRestController;
import com.wordpress.carledwinj.spring.mockito.rest.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages= {"com.wordpress.carledwinj.spring.mockito.rest"})
public class UserRestControllerTest {

	@InjectMocks
	private UserRestController restController;
	
	@Spy
	private UserServiceImpl serviceImpl;
	
	private MockMvc mockMvc;
	
	private static final String NAME = "Carl Edwin Antonio";
	
	private static final String SURNAME = "Nascimento";
	
	private static final String DATA_NAME = "data.name";
	
	private static final String DATA_SURNAME = "data.surname";
	
	private static final String URI_USER = "/user/";
	
	private static final Long PARAM_ID = 1l;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
	}
	
	
	@Test
	public void testGet() throws Exception {
		Long id = PARAM_ID;
		mockMvc.perform(get(URI_USER + id ))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath(DATA_NAME, is(NAME)))
		.andExpect(jsonPath(DATA_SURNAME, is(SURNAME)));
		//.andExpect(arg0)
	}
	
}
