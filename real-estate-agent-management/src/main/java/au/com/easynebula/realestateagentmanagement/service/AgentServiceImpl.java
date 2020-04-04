package au.com.easynebula.realestateagentmanagement.service;

import au.com.easynebula.realestateagentmanagement.domain.Agent;
import au.com.easynebula.realestateagentmanagement.dto.AgentDto;
import au.com.easynebula.realestateagentmanagement.dto.Property;
import au.com.easynebula.realestateagentmanagement.repository.AgentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static org.springframework.http.HttpStatus.OK;

@Service
@RefreshScope
public class AgentServiceImpl implements AgentService {

	private static final Logger LOG = LoggerFactory.getLogger(AgentServiceImpl.class);

	private final AgentRepository agentRepository;

	private final RestTemplate restTemplate;

	@Value("${propertyServiceUrl}")
	private String propertyServiceUrl;

	@Autowired
	public AgentServiceImpl(final AgentRepository agentRepository, final RestTemplate restTemplate) {
		this.agentRepository = agentRepository;
		this.restTemplate = restTemplate;
	}

	@Override
	public AgentDto createAgent(final AgentDto newAgent) {
		final Agent agent = new Agent();
		BeanUtils.copyProperties(newAgent, agent);
		final Agent savedAgent = agentRepository.save(agent);
		newAgent.setId(savedAgent.getId());
		return newAgent;
	}

	@Override
	public List<AgentDto> getAllAgents() {
		final List<Agent> all = agentRepository.findAll();
		final List<AgentDto> agentDtos = new ArrayList<>();
		all.forEach(agent -> {
			final AgentDto agentDto = new AgentDto();
			BeanUtils.copyProperties(agent, agentDto);
			agentDtos.add(agentDto);
		});
		return agentDtos;
	}

	@Override
	public AgentDto getAgent(String agentNumber, boolean withProperties) {
		final Optional<Agent> byAgentNumber = agentRepository.findByAgentNumber(agentNumber);
		LOG.info("retrieved agent details {}", byAgentNumber);
		final AgentDto agentDto = new AgentDto();
		return byAgentNumber.map(agent -> {
			if(withProperties) {
				getPropertyDetails(agentNumber, agentDto);
			}
			BeanUtils.copyProperties(agent, agentDto);
			LOG.info("updated agent is {} and dto is {}", byAgentNumber, agentDto);
			return agentDto;
		}).orElse(null);
	}

	private void getPropertyDetails(final String agentNumber, final AgentDto agentDto) {
		final ResponseEntity<Property[]> forEntity = restTemplate.getForEntity(propertyServiceUrl, Property[].class, agentNumber);
		final Predicate<ResponseEntity<Property[]>> predicate = responseEntity -> responseEntity.hasBody()
				&& (responseEntity.getStatusCode() == OK)
				&& responseEntity.getBody() != null;
		final List<Property> properties = predicate.test(forEntity) ? asList(forEntity.getBody()) : EMPTY_LIST;
		agentDto.setProperties(properties);
	}

	@Override
	public void deleteAgent(String agentNumber) {
		Optional<Agent> byAgentNumber = agentRepository.findByAgentNumber(agentNumber);
		agentRepository.delete(byAgentNumber.get());
	}

	@Override
	public void updateAgent(Agent updatedAgent) {
		agentRepository.save(updatedAgent);

	}
}
