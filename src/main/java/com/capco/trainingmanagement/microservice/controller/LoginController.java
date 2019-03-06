package com.capco.trainingmanagement.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capco.trainingmanagement.microservice.config.JwtTokenUtil;
import com.capco.trainingmanagement.microservice.entity.EmployeeEntity;
import com.capco.trainingmanagement.microservice.model.ApiResponse;
import com.capco.trainingmanagement.microservice.model.AuthToken;
import com.capco.trainingmanagement.microservice.model.LoginUser;
import com.capco.trainingmanagement.microservice.service.LoginService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/employee")
public class LoginController {
	
	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private JwtTokenUtil jwtTokenUtil;

	   @Autowired
	   private LoginService userService;
	   

		@RequestMapping(value = "/login", method = RequestMethod.POST)
	    public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

	        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword()));
	        final EmployeeEntity user = userService.findOne(loginUser.getEmail());
	        final String token = jwtTokenUtil.generateToken(user);
	        return new ApiResponse<>(200, "success",new AuthToken(token, user.getEmail()));
	    }

		
}
