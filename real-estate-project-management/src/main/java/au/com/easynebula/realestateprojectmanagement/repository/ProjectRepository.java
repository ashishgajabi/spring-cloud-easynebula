package au.com.easynebula.realestateprojectmanagement.repository;

import au.com.easynebula.realestateprojectmanagement.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, String> {

	Optional<Project> findByProjectNumber(String projectNumber);
}
