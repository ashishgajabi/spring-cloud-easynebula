package au.com.easynebula.realestatepropertymanagement.repository;

import au.com.easynebula.realestatepropertymanagement.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, String> {

	Optional<Property> findByPropertyNumber(String propertyNumber);

	List<Property> findByAgentNumber(String agentnumber);

	List<Property> findByProjectNumber(String projectNumber);

	@Query("SELECT p FROM Property p WHERE (:agentNumber is null or p.agentNumber = :agentNumber) and (:projectNumber is null"
			+ " or p.projectNumber = :projectNumber)")
	List<Property> findByAgentNumberAndProjectNumber(@Param("agentNumber") String agentNumber, @Param("projectNumber") String projectNumber);
}
