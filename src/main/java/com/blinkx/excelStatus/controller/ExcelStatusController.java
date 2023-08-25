package com.blinkx.excelStatus.controller;

import java.util.List;

import org.apache.batik.apps.svgbrowser.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blinkx.excelStatus.dto.ExcelStatusDto;
import com.blinkx.excelStatus.entity.ExcelStatusEntity;
import com.blinkx.excelStatus.exception.ErrorResponseDto;
import com.blinkx.excelStatus.exception.ResponseMessage;
import com.blinkx.excelStatus.exception.SuccessReponseDto;
import com.blinkx.excelStatus.service.ExcelStatusService;
import com.blinkx.excelStatus.serviceIml.ExcelHelperImpl;
import com.fasterxml.jackson.annotation.JacksonInject.Value;




@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = {"*"})
public class ExcelStatusController {

	@Autowired
	private ExcelStatusService excelStatusService;
	
	@PostMapping(value="/createExcelData" )
//	@JsonAutoDetect(getterVisibility=Visibility.NONE)
	public ResponseEntity<?> createExcelData(@RequestParam("file")MultipartFile file) throws Exception{
		
		if(ExcelHelperImpl.hasExcelFormat(file)) {
			try {
				excelStatusService.saveFile(file);
				return new ResponseEntity<>(new SuccessReponseDto("Success","File Uploaded Successfully"),HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(new ErrorResponseDto("failure", "failed to upload file"),HttpStatus.UNSUPPORTED_MEDIA_TYPE);
			}
		}
//		return new ResponseEntity<>(new SuccessReponseDto("Success","File Uploaded Successfully"),HttpStatus.CREATED);
//		else {
		return new ResponseEntity<>(new ResponseMessage("Error","please upload correct file/file"),HttpStatus.BAD_REQUEST);
//		}
	}
	
	@PostMapping("addData")
	public String addData(@RequestParam("file")MultipartFile file) {
		if(ExcelHelperImpl.hasExcelFormat(file)) {
			try {
				excelStatusService.saveFile(file);
				return "Data added Successfully";
			} catch (Exception e) {
				return "fail to add data";
			}
		}
//		return new ResponseEntity<>(new SuccessReponseDto("Success","File Uploaded Successfully"),HttpStatus.CREATED);
		else {
		return "Error, please upload correct file";
//		}
	}
	}
	
	
	@GetMapping("/getAllStatus")
	public List<ExcelStatusEntity> getAllStatus(){
		List<ExcelStatusEntity> excelStatusEntity = excelStatusService.getAllDataStatus();
		if(excelStatusEntity==null & excelStatusEntity.isEmpty()) {
//			return excelStatusEntity;
//			return new ResponseEntity<>(new SuccessReponseDto("success", "List of all Status Data", excelStatusEntity),HttpStatus.OK);
			
		}
		else {
//			return new ResponseEntity<>(new ErrorResponseDto("failure","no List found"),HttpStatus.NOT_FOUND);
		}
		return excelStatusEntity;
	}
	
//	@GetMapping("/getStatusByEmail/{email}")
//	public ResponseEntity<?> getStatusByEmail(@PathVariable String email){
//		ExcelStatusEntity excelStatusEntity = excelStatusService.getByEmail(email);
//		if(excelStatusEntity!=null) {
//			return new ResponseEntity<>(new SuccessReponseDto("success","Status Data found by email", excelStatusEntity),HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<>(new ErrorResponseDto("failure","no status data found by email"),HttpStatus.NOT_FOUND);
//		}
//	}
	
	@GetMapping("/getStatusByEmail/{email}")
	public Object getStatusByEmail(@PathVariable String email){
		ExcelStatusEntity excelStatusEntity = excelStatusService.getByEmail(email);
		if(excelStatusEntity!=null) {
			//return new ResponseEntity<>(new SuccessReponseDto("success","Status Data found by email", excelStatusEntity),HttpStatus.OK);
			return excelStatusEntity;
		}
		else {
			return null;
		}
	}
}
