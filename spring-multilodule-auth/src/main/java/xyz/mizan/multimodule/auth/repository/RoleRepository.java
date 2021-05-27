package xyz.mizan.multimodule.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.mizan.multimodule.auth.entity.ERole;
import xyz.mizan.multimodule.auth.entity.UserRole;

/**
 * @author    Md Mizanur Rahman<mizan@phaseminus.com>
 * @version   0.0.1-SNAPSHOT
 * @since     0.0.1-SNAPSHOT
 */
@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {

	Optional<UserRole> findByName(ERole name);
}
