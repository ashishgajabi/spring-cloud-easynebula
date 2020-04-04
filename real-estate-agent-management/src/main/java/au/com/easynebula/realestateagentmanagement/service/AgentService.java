package au.com.easynebula.realestateagentmanagement.service;

import au.com.easynebula.realestateagentmanagement.domain.Agent;
import au.com.easynebula.realestateagentmanagement.dto.AgentDto;

import java.util.List;

public interface AgentService {

	AgentDto createAgent(AgentDto newAgent);

	List<AgentDto> getAllAgents();

	AgentDto getAgent(String agentNumber, boolean withProperties);

	void deleteAgent(String agentNumber);

	void updateAgent(Agent updatedAgent);

}
