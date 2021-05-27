package xyz.mizan.multimodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.mizan.multimodule.entity.PatientProfile;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Repository
public interface PatientProfileRepository extends JpaRepository<PatientProfile, Integer>{

}
