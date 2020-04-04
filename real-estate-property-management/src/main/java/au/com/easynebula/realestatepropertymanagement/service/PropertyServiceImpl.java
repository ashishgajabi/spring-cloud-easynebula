package au.com.easynebula.realestatepropertymanagement.service;

import au.com.easynebula.realestatepropertymanagement.domain.Property;
import au.com.easynebula.realestatepropertymanagement.dto.Agent;
import au.com.easynebula.realestatepropertymanagement.dto.Project;
import au.com.easynebula.realestatepropertymanagement.dto.PropertyDto;
import au.com.easynebula.realestatepropertymanagement.repository.PropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
@RefreshScope
public class PropertyServiceImpl implements PropertyService {

	private static final Logger LOG = LoggerFactory.getLogger(PropertyServiceImpl.class);

	private final PropertyRepository repository;

	private final RestTemplate restTemplate;

	@Value("${agentServiceUrl}")
	private String agentServiceUrl;

	@Value("${projectServiceUrl}")
	private String projectServiceUrl;

	@Autowired
	public PropertyServiceImpl(final PropertyRepository repository, final RestTemplate restTemplate) {
		this.repository = repository;
		this.restTemplate = restTemplate;
	}

	@Override
	public PropertyDto createProperty(final PropertyDto newProperty) {
		final Property property = new Property();
		BeanUtils.copyProperties(newProperty, property);
		final Property savedProperty = repository.save(property);
		newProperty.setId(savedProperty.getId());
		return newProperty;
	}

	@Override
	public List<PropertyDto> getAllProperties(final String agentNumber, final String projectNumber) {
		final List<Property> properties = repository.findByAgentNumberAndProjectNumber(agentNumber, projectNumber);
		LOG.info("number of properties returned are {}", properties.size());
//		if(isEmpty(agentNumber) && isEmpty(projectNumber)) {
//			properties = repository.findAll();
//		} else if() {
//			properties = repository.findByAgentNumber(agentNumber);
//		}
		final List<PropertyDto> propertyDtos = new ArrayList<>();
		properties.forEach(property -> {
			final PropertyDto dto = new PropertyDto();
			BeanUtils.copyProperties(property, dto);
			propertyDtos.add(dto);
		});
		return propertyDtos;
	}

	@Override
	public PropertyDto getProperty(final String propertyNumber, boolean withAgentData, boolean withProjectData) {
		final Optional<Property> byPropertyNumber = repository.findByPropertyNumber(propertyNumber);
		final PropertyDto dto = new PropertyDto();
		return byPropertyNumber.map(property -> {
			if (withAgentData) {
				final Agent forObject = restTemplate.getForObject(format(agentServiceUrl, property.getAgentNumber()), Agent.class);
				LOG.info("retrieved agent details {}", forObject);
				dto.setAgent(forObject);
				dto.setAgentNumber(null);
			}
			if (withProjectData) {
				final Project project = restTemplate.getForObject(format(projectServiceUrl, property.getProjectNumber()), Project.class);
				LOG.info("retrieved project details {}", project);
				dto.setProject(project);
				dto.setProjectNumber(null);
			}
			BeanUtils.copyProperties(property, dto);
			return dto;
		}).orElse(null);
	}

	@Override
	public Property getPropertyByAgentNumber(final String agentNumber) {
		return null;
	}
}
