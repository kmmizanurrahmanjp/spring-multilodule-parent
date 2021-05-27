package xyz.mizan.multimodule.repository;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xyz.mizan.multimodule.comon.util.HibernateSession;
import xyz.mizan.multimodule.entity.Patient;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Repository
public class PatientRepositoryImpl implements PatientRepository{
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(PatientRepositoryImpl.class);
	
	@Autowired
	HibernateSession hibernateSession;
	
	@Override
	public int insetPatient(Patient patient) {
        Session session = hibernateSession.open();
        session.beginTransaction();
        int n = (Integer) session.save(patient);
        session.getTransaction().commit();
        session.close();
        return n;
    }
	
	@Override
	public Patient updatePatient(Patient patient){
        Session session = hibernateSession.open();
        session.beginTransaction();
        List<Patient> queryPatient = searchPatientById(patient.getPatientId());
        if(!queryPatient.isEmpty()) {
        	session.update(patient);
            session.getTransaction().commit();
            session.close();
            return patient;
        }
        session.close();
        return null;
    }
	
	@Override
	public boolean deletePatient(int id){
        Session session = hibernateSession.open();
        session.beginTransaction();
        List<Patient> queryPatient = searchPatientById(id);
        if(!queryPatient.isEmpty()) {
        	session.createQuery("Delete Patient where id = "+id).executeUpdate();
            session.getTransaction().commit();
            session.close();
            return true;
        }
        return false;	
    }
	
	@Override
	public List<Patient> selectAllPatient(){
		List<Patient> patientList;
        Session session = hibernateSession.open();
        session.beginTransaction();
        patientList = session.createQuery("from Patient").list();
        session.close();
        return patientList;
    }
	
	@Override
	public List<Patient> searchPatientById(int id) {
		Session session = hibernateSession.open();
        session.beginTransaction();
        List<Patient> patients = session.createQuery("from Patient where patientId="+id).list();
        session.close();
        return patients;
	}
	
	@Override
	public List<Patient> selectPatientByCriteria(Patient patient){
		List<Patient> patientList;
		String patientNo = "";
		if(patient.getPatientId() != 0){
			patientNo = String.valueOf(patient.getPatientId());
		}
		System.out.println(patientNo);
		Session session = hibernateSession.open();
		session.beginTransaction();
		patientList = session.createQuery(
				"from Patient where patientId like '%"+patientNo+"%'"
				+ " and patientName like '%"+patient.getPatientName()+"%'"
				+ " and patientPhone like '%"+patient.getPatientPhone()+"%'"
				).list();
		session.close();
		return patientList;
	}
	
}
