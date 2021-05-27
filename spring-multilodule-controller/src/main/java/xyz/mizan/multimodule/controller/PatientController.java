package xyz.mizan.multimodule.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import xyz.mizan.multimodule.comon.util.ApiResponse;
import xyz.mizan.multimodule.entity.Patient;
import xyz.mizan.multimodule.service.PatientServiceImpl;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/patient")
public class PatientController {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	ApiResponse apiResponse;

	@Autowired
	PatientServiceImpl patientServiceImpl;

	// Get: selectAllPatient
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> selectAllPatient() {
		List<Patient> pat = patientServiceImpl.selectAllPatient();
		if (pat.isEmpty()) {
			return new ResponseEntity<Object>(apiResponse.getFailed(null), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(apiResponse.getSuccessMultiData(pat), HttpStatus.OK);
		}
	}

	// Get: selectPatientById
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> selectPatientById(@PathVariable int id) {
		List<Patient> patient = patientServiceImpl.searchPatientById(id);
		if (patient.isEmpty()) {
			return new ResponseEntity<Object>(apiResponse.getFailed(null), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(apiResponse.getSuccessSingleData(patient.get(0)), HttpStatus.OK);
		}
	}

	// Get: selectPatientByCriteria
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ResponseEntity<Object> selectPatientByCriteria(
			@RequestParam(value = "id", required = false) String patientId,
			@RequestParam(value = "name", required = false) String patientName,
			@RequestParam(value = "address", required = false) String patientAddress,
			@Valid @RequestParam(value = "phone", required = false) String patientPhone) {

		Patient patient = new Patient();
		if (patientId != "") {
			patient.setPatientId(Integer.valueOf(patientId));
		} else {
			patient.setPatientId(0);
		}
		patient.setPatientName(patientName);
		patient.setPatientAddress(patientAddress);
		patient.setPatientPhone(patientPhone);
		List<Patient> query = patientServiceImpl.selectPatientByCriteria(patient);
		if (query.isEmpty()) {
			return new ResponseEntity<Object>(apiResponse.getFailed(null), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(apiResponse.getSuccessMultiData(query), HttpStatus.OK);
		}
	}

	// Post: addPatient
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addPatient(@Valid @RequestBody Patient patient) {
		int pat = patientServiceImpl.insetPatient(patient);
		if (pat == 0) {
			return new ResponseEntity<Object>(apiResponse.insertFailed(pat), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(apiResponse.insertSuccess(pat), HttpStatus.OK);
		}
	}

	// Put: updatePatient
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Object> updatePatient(@Valid @RequestBody Patient patient) {
		Patient pat = patientServiceImpl.updatePatient(patient);
		if (pat == null) {
			return new ResponseEntity<Object>(apiResponse.updateFailed(pat), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(apiResponse.updateSuccess(pat), HttpStatus.OK);
		}
	}

	// Delete: deletePatient
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePatient(@PathVariable int id) {
		Patient patient = new Patient();
		patient.setPatientId(id);
		if (patientServiceImpl.deletePatient(id) == true) {
			return new ResponseEntity<Object>(apiResponse.deleteSuccess(null), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(apiResponse.deleteFailed(patient), HttpStatus.OK);
		}
	}
}
