package xyz.mizan.multimodule.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.mizan.multimodule.entity.Patient;
import xyz.mizan.multimodule.repository.PatientRepositoryImpl;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Service
public class PatientServiceImpl implements PatientService{

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(PatientServiceImpl.class);
	
	@Autowired
	PatientRepositoryImpl patientRepositoryImpl;
	
	@Override
	public int insetPatient(Patient patient){
		return patientRepositoryImpl.insetPatient(patient);
	}
	
	@Override
	public Patient updatePatient(Patient patient){
		return patientRepositoryImpl.updatePatient(patient);
	}
	
	@Override
	public boolean deletePatient(int id){
		return patientRepositoryImpl.deletePatient(id);
		
	}
	
	@Override
	public List<Patient> selectAllPatient(){
		return patientRepositoryImpl.selectAllPatient();
	}
	
	@Override
	public List<Patient> searchPatientById(int id){
		return patientRepositoryImpl.searchPatientById(id);
		
	}
	
	@Override
	public List<Patient> selectPatientByCriteria(Patient patient){
		return patientRepositoryImpl.selectPatientByCriteria(patient);
	}
}
