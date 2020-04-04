package au.com.easynebula.realestatepropertymanagement.controller;

import au.com.easynebula.realestatepropertymanagement.dto.PropertyDto;
import au.com.easynebula.realestatepropertymanagement.service.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/properties")
public class PropertyController {

	private static final Logger LOG = LoggerFactory.getLogger(PropertyController.class);

	private final PropertyService service;

	@Autowired
	public PropertyController(final PropertyService service) {
		this.service = service;
	}

	@GetMapping
	public List<PropertyDto> getAllProperties(@RequestParam(value = "agentNumber", required = false) final String agentNumber,
	                                          @RequestParam(value = "projectNumber", required = false) final String projectNumber) {
		LOG.info("Retrieveing all properties data with agent number {} and project number {}", agentNumber, projectNumber);
		return service.getAllProperties(agentNumber, projectNumber);
	}

	@GetMapping("/{propertyNumber}")
	public PropertyDto getPropery(@NotNull @PathVariable("propertyNumber") final String propertyNumber,
	                              @RequestParam(value = "withAgentData", required = false, defaultValue = "false") final boolean withAgentData,
	                              @RequestParam(value = "withProjectData", required = false, defaultValue = "false") final boolean withProjectData) {
		LOG.info("Returning Property for property number {} and with agent data needed {}", propertyNumber, withAgentData);
		return service.getProperty(propertyNumber, withAgentData, withProjectData);
	}

	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public PropertyDto createProperty(@RequestBody final PropertyDto property) {
		return service.createProperty(property);
	}

}
