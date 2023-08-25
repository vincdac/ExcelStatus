package com.blinkx.excelStatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.blinkx.excelStatus.entity.ExcelStatusEntity;

import jakarta.transaction.Transactional;

public interface ExcelStatusRepository extends JpaRepository<ExcelStatusEntity, Long>{
	
	@Query(value="select * from m_dump_data where email =:email",nativeQuery = true)
	ExcelStatusEntity getByEmail(@RequestParam("email")String email); 
	
	@Transactional
	@Query(value = "SELECT setval('m_dump_data_id_seq', 1, false)", nativeQuery = true)
	void restartIdentity();

}
