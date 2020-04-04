package au.com.easynebula.realestateagentmanagement.controller;

import au.com.easynebula.realestateagentmanagement.dto.AgentDto;
import au.com.easynebula.realestateagentmanagement.service.AgentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/agents")
@RefreshScope
public class AgentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AgentController.class);

	private final AgentService service;

	@Value("${greeting}")
	private String greeting;

	@Autowired
	public AgentController(final AgentService service) {
		this.service = service;
	}

	@GetMapping
	public List<AgentDto> getAllAgents() {
		return service.getAllAgents();
	}

	@GetMapping(path = "/{agentNumber}")
	public AgentDto getAgent(@PathVariable("agentNumber") final String agentNumber,
	                         @RequestParam(value = "withProperties", required = false, defaultValue = "false") final boolean withProperties) {
		LOGGER.info("Retrieving agent for agent number {} with properties {} and greeting text {}", agentNumber, withProperties, greeting);
		return service.getAgent(agentNumber, withProperties);
	}

	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public AgentDto createAgent(@RequestBody final AgentDto newAgent) {
		return service.createAgent(newAgent);
	}
}