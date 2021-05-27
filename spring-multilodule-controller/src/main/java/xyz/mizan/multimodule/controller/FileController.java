package xyz.mizan.multimodule.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import xyz.mizan.multimodule.comon.util.ApiResponse;
import xyz.mizan.multimodule.comon.util.FileUtility;
import xyz.mizan.multimodule.entity.PatientProfile;
import xyz.mizan.multimodule.service.PatientProfileService;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/patient/profile")
public class FileController {

	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	ApiResponse apiResponse;
	
	@Autowired
	FileUtility fileUtility;

	@Autowired
	PatientProfileService profileService;

	@PostMapping("/upload/to/db")
	public ResponseEntity<Object> uploadFileToDB(@RequestParam("file") MultipartFile file) throws IOException {
		PatientProfile fileInfo = profileService.storeFile(file);
		if(ObjectUtils.isEmpty(fileInfo)) {
			return new ResponseEntity<Object>(apiResponse.uploadFailed(fileInfo.getFileName(), fileInfo.getFileType()), HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(apiResponse.uploadSuccess(fileInfo.getId().toString(), fileInfo.getFileName(), fileInfo.getFileType()), HttpStatus.OK);
		}
	}

	//Fixed
	/*@PostMapping("/uploadMultiple")
	public List<ResponseEntity<Object>> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
	}*/

	@GetMapping("/download/from/db/{id}")
	public ResponseEntity<Resource> downloadFileFromDB(@PathVariable Integer id) {
		PatientProfile fileinfo = profileService.getFile(id);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileinfo.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileinfo.getFileName() + "\"")
				.body(new ByteArrayResource(fileinfo.getData()));
	}
	
	
	@PostMapping("/upload/to/dir")
	public String uploadFileToDir(@RequestParam("file") MultipartFile file) throws IOException {
		return fileUtility.uploadToDir(file);
	}
	
	
	@GetMapping("/download/from/dir")
	public ResponseEntity<?> downloadFileFromDir(@RequestParam("fileName") String fileName) throws IOException {
		return fileUtility.downloadFromDir(fileName);
	}

}
