package com.budgetflows.springserverapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetflows.springserverapi.controller.util.AppException;
import com.budgetflows.springserverapi.controller.util.Error;
import com.budgetflows.springserverapi.controller.util.Response;
import com.budgetflows.springserverapi.entity.User;
import com.budgetflows.springserverapi.service.UserService;

@RestController
@RequestMapping("/api/flutter/auth")
public class FlutterAuthController {

	@Autowired
	private UserService service;

	@PostMapping(value = "/login", produces = { "application/json",
	"application/xml" }, consumes = { "application/x-www-form-urlencoded" })
	public Response login(User info) {
		try {
			User user = service.login(info.getEmail(), info.getPassword());
			return Response.success(user);
		} catch (AppException e) {
			Error error = new Error(400, e.getMessage());
			return Response.error(error);
		}
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { "application/json",
//			"application/xml" }, consumes = { "application/x-www-form-urlencoded" })
//	public Response loginXwwwFormUrlencoded(@RequestBody User info) {
//		try {
//			User user = service.login(info.getEmail(), info.getPassword());
//			return Response.success(user);
//		} catch (AppException e) {
//			Error error = new Error(400, e.getMessage());
//			return Response.error(error);
//		}
//	}

	@PostMapping(value="/register", produces = { "application/json",
	"application/xml" }, consumes = { "application/x-www-form-urlencoded" })
	public Response register(User info) {//@RequestBody 
		try {
			return Response.success(service.register(info));
		} catch (Exception e) {
			Error error = new Error(400, e.getMessage());
			return Response.error(error);
		}
	}
}
