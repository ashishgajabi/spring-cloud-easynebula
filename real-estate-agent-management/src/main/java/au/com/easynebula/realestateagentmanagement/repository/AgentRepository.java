package au.com.easynebula.realestateagentmanagement.repository;

import au.com.easynebula.realestateagentmanagement.domain.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent, String> {

	Optional<Agent> findByAgentNumber(String agentNumber);
}
