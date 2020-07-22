package com.budgetflows.springserverapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetflows.springserverapi.controller.dto.RecordToRetrieveDTO;
import com.budgetflows.springserverapi.controller.util.AppException;
import com.budgetflows.springserverapi.entity.Record;
import com.budgetflows.springserverapi.repository.RecordRepository;

@Service
public class RecordService {

	@Autowired
	private RecordRepository repo;
	
	public List<Record> getRecordsOf(String email) throws AppException {
		try {
			return repo.getRecordsOf(email);
		} catch (Exception e) {
			throw new AppException("Email not found");
		}
		
	}
	
	public List<RecordToRetrieveDTO> gets(String email) throws AppException {
		try {
			return repo.gets(email);
		} catch (Exception e) {
			throw new AppException("Email not found with gets");
		}
		
	}
	
	public Record create(Record record) throws AppException{
		try {
			return repo.save(record);
		} catch (Exception e) {
			throw new AppException("Can not create new record");
		}
	}
	
	public void delete(int id) throws AppException {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("Id does not existed");
		} 
	}
}
