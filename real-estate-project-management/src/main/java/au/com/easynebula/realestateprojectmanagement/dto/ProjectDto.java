package au.com.easynebula.realestateprojectmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class ProjectDto {

	private String id;

	private String projectNumber;

	private String name;

	private String turnOver;

	private String address;

	private String state;

	private String projectManagerName;

	private List<Property> properties;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(final String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(final String turnOver) {
		this.turnOver = turnOver;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(final String state) {
		this.state = state;
	}

	public String getProjectManagerName() {
		return projectManagerName;
	}

	public void setProjectManagerName(final String projectManagerName) {
		this.projectManagerName = projectManagerName;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(final List<Property> properties) {
		this.properties = properties;
	}
}
