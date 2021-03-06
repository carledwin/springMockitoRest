package com.wordpress.carledwinj.spring.mockito.rest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordpress.carledwinj.spring.mockito.rest.model.User;
import com.wordpress.carledwinj.spring.mockito.rest.service.UserService;
import com.wordpress.carledwinj.spring.mockito.rest.stub.RestResponse;

@RestController
@RequestMapping(value="/user")
public class UserRestController {

	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public RestResponse<User> get(@PathVariable("id") Long id){
		
		return new RestResponse<User>(true, "Message Success get User...", HttpStatus.OK, User.mock(id));
	}
	
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public RestResponse<String> post(@RequestBody User user) {
		
		boolean success = service.save(user);
		if(success) {
			
			return new RestResponse<String>(success, "Message Success post User...", HttpStatus.CREATED, null);
		}
			
		return new RestResponse<String>(success, "Message Error post User...", HttpStatus.BAD_REQUEST, null);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE , produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse<String> delete(@PathVariable("id") Long id){
		
		boolean success = service.delete(id);
		if(success) {
			
			return new RestResponse<String>(success, "Message Success delete User...", HttpStatus.NO_CONTENT, null);
		}
		
		return new RestResponse<String>(success, "Message Error delete User...", HttpStatus.BAD_REQUEST, null);
	}
	
	@RequestMapping(method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse<String> put(@RequestBody User user){
		
		boolean success = service.update(user);
		if(success) {
			
			return new RestResponse<String>(success, "Message Success put User...", HttpStatus.BAD_REQUEST, null);
		}
		
		return new RestResponse<String>(success, "Message Error put User...", HttpStatus.BAD_REQUEST, null);
	}
	
	
}
