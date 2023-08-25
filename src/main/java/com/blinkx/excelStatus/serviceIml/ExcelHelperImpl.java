package com.blinkx.excelStatus.serviceIml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.blinkx.excelStatus.entity.ExcelStatusEntity;
import com.blinkx.excelStatus.repository.ExcelStatusRepository;

public class ExcelHelperImpl {
	
	private final static String data="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	
//	static String SHEET="MySheet1";
	
	
	public static boolean hasExcelFormat(MultipartFile file) {
		if(!data.equals(file.getContentType())) {
			return false;
		}
		else {
//
			return true;
		}
	}
	
	
	public static List<ExcelStatusEntity> convertExcelSheetToSql(InputStream inputStream) throws Exception {
		try {
		Workbook workbook=new XSSFWorkbook(inputStream);
		String sheetName = workbook.getSheetName(0);
		Sheet sheet = workbook.getSheet(sheetName);
		Iterator<Row> iterator = sheet.iterator();
		List<ExcelStatusEntity> dumpData=new ArrayList<ExcelStatusEntity>();
		int rowNumber=0;
		while(iterator.hasNext()) {
			Row currentRow = iterator.next();
			
			if(rowNumber==0) {
				rowNumber++;
				continue;
			}
		
			Iterator<Cell> cellsInRow = currentRow.iterator();
			
			ExcelStatusEntity excelStatusEntity=new ExcelStatusEntity();
			
			int cellIdx=0;
			while(cellsInRow.hasNext()) {
				Cell currentCell = cellsInRow.next();
				switch (cellIdx) {
				case 0:
					excelStatusEntity.setEmail(currentCell.getStringCellValue());
				break;
				case 1:
					excelStatusEntity.setMandateId(currentCell.getStringCellValue());
				break;
				case 2:
					excelStatusEntity.setBankName(currentCell.getStringCellValue());
				break;
				case 3:
					excelStatusEntity.setAccountNumber(currentCell.getStringCellValue());
				break;
				case 4:
					excelStatusEntity.setBankId(currentCell.getStringCellValue());
				break;
				case 5:
					excelStatusEntity.setAmount(currentCell.getNumericCellValue());
				break;
				case 6:
					String stringCellValue = currentCell.getStringCellValue();
					if(stringCellValue.isEmpty()) {
					excelStatusEntity.setUmrn("1");
					}
					else {
						excelStatusEntity.setUmrn(stringCellValue);
					}
//					System.out.println("empty");
				break;
				case 7:
					excelStatusEntity.setType(currentCell.getStringCellValue());
				break;
				case 8:
					excelStatusEntity.setRegistration_date(currentCell.getStringCellValue());
				break;
				case 9:
					excelStatusEntity.setApproved_date(currentCell.getStringCellValue());
//					System.out.println("empty");
				break;
				case 10:
					excelStatusEntity.setStatus(currentCell.getStringCellValue());
				break;
				case 11:
					excelStatusEntity.setStatusReason(currentCell.getStringCellValue());
//					System.out.println("empty");
				break;
				case 12:
					excelStatusEntity.setSubStatus(currentCell.getStringCellValue());
//					System.out.println("empty");

				break;
				}
				cellIdx++;
			}
			dumpData.add(excelStatusEntity);
		}
		workbook.close();
		
		return dumpData;
	}
		
	catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }

	}

}
