package com.cybertech.service.impl;

import com.cybertech.entity.OnDuty;
import com.cybertech.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/12/24. 4:23 PM
 */
@Service
@Slf4j
public class FileServiceImpl implements FileService {


	@Override
	public Integer batchImport(String fileName, MultipartFile file) {

		boolean notNull = false;
		Integer status = 1;
		List<OnDuty> resultList = new ArrayList<>();
		try{
			if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
				String error = "上传文件格式不正确";
				status = 0;
				return status;
			}
			boolean isExcel2003 = true;
			if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
				isExcel2003 = false;
			}
			InputStream is = file.getInputStream();
			Workbook wb = null;
			if (isExcel2003) {
				wb = new HSSFWorkbook(is);
			} else {
				wb = new XSSFWorkbook(is);
			}
			Sheet sheet = wb.getSheetAt(0);
			if(sheet!=null){
				notNull = true;
			}
			for (int r = 0; r < sheet.getLastRowNum(); r++) {
				Row row = sheet.getRow(r);
				if (row == null){
					continue;
				}
				OnDuty onDuty = new OnDuty();
				row.getCell(1).setCellType(CellType.STRING);//设置读取转String类型
				row.getCell(2).setCellType(CellType.STRING);
				row.getCell(3).setCellType(CellType.STRING);
				row.getCell(4).setCellType(CellType.STRING);
				row.getCell(5).setCellType(CellType.STRING);

				String user_id = row.getCell(1).getStringCellValue();
				String userName = row.getCell(1).getStringCellValue();
				String jgbm = row.getCell(3).getStringCellValue();
				String dbld = row.getCell(4).getStringCellValue();
				String duty_date = row.getCell(5).getStringCellValue();
				onDuty.setDbld(dbld);
				onDuty.setDuty_date(duty_date);
				onDuty.setJgbm(jgbm);
				onDuty.setUser_id(user_id);
				onDuty.setUserName(userName);
				System.out.println(onDuty);
			}
		}catch (Exception e){
			e.printStackTrace();
			log.error("上传Excel出错......");
		}

		return status;
	}
}
