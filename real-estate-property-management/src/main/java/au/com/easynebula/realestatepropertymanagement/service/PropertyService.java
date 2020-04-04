package au.com.easynebula.realestatepropertymanagement.service;

import au.com.easynebula.realestatepropertymanagement.domain.Property;
import au.com.easynebula.realestatepropertymanagement.dto.PropertyDto;

import java.util.List;

public interface PropertyService {

	PropertyDto createProperty(PropertyDto newProperty);
	List<PropertyDto> getAllProperties(String agentNumber, String projectNumber);
	PropertyDto getProperty(String propertyNumber, boolean withAgentData, boolean withProjectData);
	Property getPropertyByAgentNumber(String agentNumber);
}
