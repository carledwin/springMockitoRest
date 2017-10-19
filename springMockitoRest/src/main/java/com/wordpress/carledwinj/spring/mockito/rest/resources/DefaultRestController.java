package com.wordpress.carledwinj.spring.mockito.rest.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordpress.carledwinj.spring.mockito.rest.exception.UnknownResourceException;

@RestController
public class DefaultRestController {

	@RequestMapping("/**")
	public void unmappedRequest(HttpServletRequest httpServletRequest) {
		
		String uri = httpServletRequest.getRequestURI();
		throw new UnknownResourceException("There is no resource for path " + uri);
	}

}
