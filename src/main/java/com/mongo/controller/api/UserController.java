package com.mongo.controller.api;

import com.mongo.common.Response;
import com.mongo.domain.User;
import com.mongo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RefreshScope
@Controller
@Api(tags = {"Users"})
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Value("${test.url}")
    private String urlTest;

	@GetMapping
	@ApiOperation(
			value = "Service used to search user."
	)
	@ApiResponses(
			value = {
					@ApiResponse(code = 401, message = "Unauthorized", response = Response.class),
					@ApiResponse(code = 403, message = "Forbidden", response = Response.class),
					@ApiResponse(code = 404, message = "Component not found"),
					@ApiResponse(code = 405, message = "Data input not supplied or invalid", response = Response.class),
					@ApiResponse(code = 406, message = "Exception", response = Response.class)
			}
	)
	public ResponseEntity<List<User>> findAll() {
		System.out.println(":: TESTE URL :: "+urlTest);
			return new ResponseEntity<>(userService.find(),HttpStatus.OK);
			
		
	}
	
}
