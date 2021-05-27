package xyz.mizan.multimodule.service;

import org.springframework.web.multipart.MultipartFile;

import xyz.mizan.multimodule.entity.PatientProfile;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public interface PatientProfileService {

	public PatientProfile storeFile(MultipartFile file);
	public PatientProfile getFile(Integer fileId);
}
