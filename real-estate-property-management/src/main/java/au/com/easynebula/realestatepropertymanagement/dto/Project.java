package au.com.easynebula.realestatepropertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"id",
		"projectNumber",
		"name",
		"turnOver",
		"address",
		"state",
		"projectManagerName"
})
public class Project {

	@JsonProperty("id")
	private String id;

	@JsonProperty("projectNumber")
	private String projectNumber;

	@JsonProperty("name")
	private String name;

	@JsonProperty("turnOver")
	private String turnOver;

	@JsonProperty("address")
	private String address;

	@JsonProperty("state")
	private String state;

	@JsonProperty("projectManagerName")
	private String projectManagerName;

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

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("projectNumber", projectNumber).append("name", name).append("turnOver", turnOver).append("address", address).append("state", state).append("projectManagerName", projectManagerName).toString();
	}
}