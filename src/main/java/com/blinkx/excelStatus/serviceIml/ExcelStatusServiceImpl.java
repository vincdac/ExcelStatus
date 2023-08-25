package com.blinkx.excelStatus.serviceIml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blinkx.excelStatus.dto.ExcelStatusDto;
import com.blinkx.excelStatus.entity.Constant;
import com.blinkx.excelStatus.entity.ExcelStatusEntity;
import com.blinkx.excelStatus.repository.ExcelStatusRepository;
import com.blinkx.excelStatus.service.ExcelStatusService;

import jakarta.transaction.Transactional;

@Service
public class ExcelStatusServiceImpl implements ExcelStatusService{
	
	@Autowired
	private ExcelStatusRepository excelStatusRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	
	public ExcelStatusEntity dtoToEntity(ExcelStatusDto excelStatusDto) {
		ExcelStatusEntity excelStatusEntity = modelMapper.map(excelStatusDto, ExcelStatusEntity.class);
		return excelStatusEntity;
	}

	
	@Transactional
	@Override
	public void saveFile(MultipartFile file) throws Exception {
//		try {
		excelStatusRepository.deleteAll();
		excelStatusRepository.restartIdentity();
		 List<ExcelStatusEntity> convertExcelSheetToSql = ExcelHelperImpl.convertExcelSheetToSql(file.getInputStream());
		 excelStatusRepository.saveAll(convertExcelSheetToSql);
//		}
//		catch (Exception e) {
//			 throw new RuntimeException("fail to store excel data: " + e.getMessage());
//			 }
	}

	@Override
	public List<ExcelStatusEntity> getAllDataStatus() {
	List<ExcelStatusEntity> excelStatusEntity = excelStatusRepository.findAll();
//	List<ExcelStatusDto> excelDto = excelStatusEntity.stream().map(dto->modelMapper.map(dto, ExcelStatusDto.class)).collect(Collectors.toList());
//		return excelStatusRepository.findAll();
	return excelStatusEntity;
	}

	@Override
	public ExcelStatusEntity getByEmail(String email) {
		ExcelStatusEntity excelStatusEntity = excelStatusRepository.getByEmail(email);
		return excelStatusEntity;
	}
	
}
