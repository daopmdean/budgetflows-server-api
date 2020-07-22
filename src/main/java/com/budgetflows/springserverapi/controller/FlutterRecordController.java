package com.budgetflows.springserverapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.budgetflows.springserverapi.controller.dto.RecordToCreateDTO;
import com.budgetflows.springserverapi.controller.dto.RecordToRetrieveDTO;
import com.budgetflows.springserverapi.controller.util.AppException;
import com.budgetflows.springserverapi.controller.util.Error;
import com.budgetflows.springserverapi.controller.util.Response;
import com.budgetflows.springserverapi.entity.Record;
import com.budgetflows.springserverapi.entity.User;
import com.budgetflows.springserverapi.service.RecordService;
import com.budgetflows.springserverapi.service.UserService;

@RestController
@RequestMapping("/api/flutter/record")
public class FlutterRecordController {

	@Autowired
	private RecordService recordService;

	@Autowired
	private UserService userService;

	@PostMapping(value="/get", produces = { "application/json",
	"application/xml" }, consumes = { "application/x-www-form-urlencoded" })
	public Response getRecords(User user) {//@RequestBody 
		try {
			String userEmail = user.getEmail();
			boolean userExisted = userService.existUser(userEmail);

			if (!userExisted) {
				throw new AppException("Can not find user with email: " + userEmail);
			}

			List<Record> records = recordService.getRecordsOf(userEmail);
			return Response.success(records);
		} catch (AppException e) {
			Error error = new Error(e.getStatusCode(), e.getMessage());
			return Response.error(error);
		} catch (Exception e) {
			Error error = new Error(400, e.getMessage());
			return Response.error(error);
		}
	}
	
	@GetMapping("/gets")
	public Response gets(@RequestBody User user) {
		try {
			String userEmail = user.getEmail();
			boolean userExisted = userService.existUser(userEmail);

			if (!userExisted) {
				throw new AppException("Can not find user with email: " + userEmail);
			}

			List<RecordToRetrieveDTO> records = recordService.gets(userEmail);
			return Response.success(records);
		} catch (AppException e) {
			Error error = new Error(e.getStatusCode(), e.getMessage());
			return Response.error(error);
		} catch (Exception e) {
			Error error = new Error(400, e.getMessage());
			return Response.error(error);
		}
	}

	@PostMapping(value="/create", produces = { "application/json",
	"application/xml" }, consumes = { "application/x-www-form-urlencoded" })
	public Response createRecord(RecordToCreateDTO newRecord) {//@RequestBody 
		try {
			User user = userService.getUser(newRecord.getUser_email());
			double money = newRecord.getMoney();
			String reason = newRecord.getReason();
			Record record = new Record(money, reason, user);
			record.setCreated(new Date());
			recordService.create(record);
			return Response.success(record);
		} catch (Exception e) {
			Error error = new Error(400, e.getMessage());
			return Response.error(error);
		}
	}
	
	@DeleteMapping(value="/delete/{id}")
	public Response deleteRecord(@PathVariable  int id) { 
		try {
			recordService.delete(id);
			return Response.success("Delete record with id: " + id);
		} catch (Exception e) {
			Error error = new Error(400, e.getMessage());
			return Response.error(error);
		}
	}
}
