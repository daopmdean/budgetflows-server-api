package com.budgetflows.springserverapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.budgetflows.springserverapi.controller.dto.RecordToRetrieveDTO;
import com.budgetflows.springserverapi.entity.Record;

public interface RecordRepository extends JpaRepository<Record, Integer> {

	@Query(value = "SELECT record_id, money, reason, created, user_email FROM record WHERE record.user_email = :email", nativeQuery = true)
	public List<Record> getRecordsOf(@Param(value = "email") String email);
	
	@Query(value = "SELECT money, reason, created FROM record WHERE record.user_email = :email", nativeQuery = true)
	public List<RecordToRetrieveDTO> gets(@Param(value = "email") String email);

	@Query(value = "SELECT record_id, money, reason, created, user_email FROM record WHERE record.user_email = :email", nativeQuery = true)
	public List<Record> getFullRecordsOf(@Param(value = "email") String email);

}
