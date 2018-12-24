package com.cybertech.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/12/24. 4:23 PM
 */
public interface FileService {


	Integer batchImport(String fileName, MultipartFile file);
}
