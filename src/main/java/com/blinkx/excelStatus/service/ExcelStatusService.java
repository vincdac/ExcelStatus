package com.blinkx.excelStatus.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.blinkx.excelStatus.dto.ExcelStatusDto;
import com.blinkx.excelStatus.entity.ExcelStatusEntity;

public interface ExcelStatusService {
	
	public void saveFile(MultipartFile file) throws Exception;
	
	public List<ExcelStatusEntity> getAllDataStatus();
	
	ExcelStatusEntity getByEmail(String email);
	

}
