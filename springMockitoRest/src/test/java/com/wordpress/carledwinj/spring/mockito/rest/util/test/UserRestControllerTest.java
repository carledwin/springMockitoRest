package com.wordpress.carledwinj.spring.mockito.rest.util.test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wordpress.carledwinj.spring.mockito.rest.exception.UnknownResourceException;
import com.wordpress.carledwinj.spring.mockito.rest.model.User;
import com.wordpress.carledwinj.spring.mockito.rest.resources.UserRestController;
import com.wordpress.carledwinj.spring.mockito.rest.service.impl.UserServiceImpl;
import com.wordpress.carledwinj.spring.mockito.rest.util.TestUtil;

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
	
	private static final Long QUERY_PARAM_ID = 3l;
	
	@Before
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
	}
	
	
	@Test
	public void testGet() throws Exception {
	
		mockMvc.perform(get(URI_USER + PARAM_ID ))
		.andExpect(jsonPath(DATA_NAME, is(NAME)))
		.andExpect(jsonPath(DATA_SURNAME, is(SURNAME)))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(status().isOk());
	}
	
	
	@Test
	public void testSave() throws JsonProcessingException, Exception {
		
		mockMvc.perform(post(URI_USER)
						.content(TestUtil.convertObjectToJsonBytes(new User()))
						.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
						)
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("success", is(true)));
	}
	
	
	@Test
	public void testUpdate() throws JsonProcessingException, Exception {
		mockMvc.perform(put(URI_USER)
						.content(TestUtil.convertObjectToJsonBytes(new User()))
						.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
						)
		.andExpect(status().isOk())
		.andExpect(jsonPath("success", is(true)));
	}
	
	
	@Test
	public void testDelete() throws Exception {
		mockMvc.perform(delete(URI_USER + QUERY_PARAM_ID))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("success", is(true)));
	}
	
	@Test
	public void testUnknownResource() throws Exception {
		mockMvc.perform(get("/**"));
	}
	
}
