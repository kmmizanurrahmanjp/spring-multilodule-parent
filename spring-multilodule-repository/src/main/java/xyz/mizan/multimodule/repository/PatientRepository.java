package xyz.mizan.multimodule.repository;

import java.util.List;

import xyz.mizan.multimodule.entity.Patient;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
public interface PatientRepository {

	public int insetPatient(Patient patient);
	public Patient updatePatient(Patient patient);
	public boolean deletePatient(int id);
	
	public List<Patient> selectAllPatient();
	public List<Patient> searchPatientById(int id);
	public List<Patient> selectPatientByCriteria(Patient patient);
}
