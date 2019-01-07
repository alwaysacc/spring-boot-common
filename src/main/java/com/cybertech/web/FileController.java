package com.cybertech.web;

import com.cybertech.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/12/24. 3:28 PM
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

	@Autowired
	FileService fileService;

	@PostMapping("/upload")
	public Object uploadExcelFile(@RequestParam("file") MultipartFile file){

		String info = "";
		try{
			String fileName = file.getOriginalFilename();
			if(fileService.batchImport(fileName,file) ==0){
//				resultBean.setMsg("上传文件格式不正确");
//				resultBean.setCode(1);
				System.out.println("上传成功。。。。。。");
			}else{
//				resultBean.setMsg("导入成功");
			}
			info = "success";
		}catch (Exception e){
			log.error("上传excel文件出错......");
			e.printStackTrace();
			info="error";
		}
		return info;
	}
}
