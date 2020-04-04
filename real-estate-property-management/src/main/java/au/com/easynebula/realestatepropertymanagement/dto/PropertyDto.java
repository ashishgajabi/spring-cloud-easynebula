package au.com.easynebula.realestatepropertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PropertyDto {

	private String Id;

	private String propertyNumber;

	private String address;

	private String postcode;

	private String layout;

	private String agentNumber;

	private Agent agent;

	private String projectNumber;

	private Project project;

	public String getId() {
		return Id;
	}

	public void setId(final String id) {
		Id = id;
	}

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(final String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(final String postcode) {
		this.postcode = postcode;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(final String layout) {
		this.layout = layout;
	}

	public String getAgentNumber() {
		return agentNumber;
	}

	public void setAgentNumber(final String agentNumber) {
		this.agentNumber = agentNumber;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(final Agent agent) {
		this.agent = agent;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(final String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(final Project project) {
		this.project = project;
	}
}
