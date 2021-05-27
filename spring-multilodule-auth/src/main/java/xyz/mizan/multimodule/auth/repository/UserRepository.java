package xyz.mizan.multimodule.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.mizan.multimodule.auth.entity.AppUser;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

	Optional<AppUser> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
