package xyz.mizan.multimodule.service;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import xyz.mizan.multimodule.entity.PatientProfile;
import xyz.mizan.multimodule.repository.PatientProfileRepository;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Service
public class PatientProfileServiceImpl implements PatientProfileService{
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(PatientProfileServiceImpl.class);
	
	@Autowired
	PatientProfileRepository repo;

	@Override
	public PatientProfile storeFile(MultipartFile file) {
		// Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
            	return null;
            }

            PatientProfile dbFile = new PatientProfile(fileName, file.getContentType(), file.getBytes());

            return repo.save(dbFile);
        } catch (IOException ex) {
        	return null;
        }
	}

	@Override
	public PatientProfile getFile(Integer fileId) {
		Optional<PatientProfile> a = repo.findById(fileId);
		return a.isPresent() ? a.get(): null;
	}

}
