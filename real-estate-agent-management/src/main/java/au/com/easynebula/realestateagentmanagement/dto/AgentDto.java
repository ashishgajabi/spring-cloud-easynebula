package au.com.easynebula.realestateagentmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class AgentDto {

	private String id;

	private String agentNumber;

	private String firstName;

	private String lastName;

	private String contactNumber;

	private String emailAddress;

	private String rating;

	private List<Property> properties;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getAgentNumber() {
		return agentNumber;
	}

	public void setAgentNumber(final String agentNumber) {
		this.agentNumber = agentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(final String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(final String rating) {
		this.rating = rating;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(final List<Property> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "AgentDto{" +
				"id='" + id + '\'' +
				", agentNumber='" + agentNumber + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", contactNumber='" + contactNumber + '\'' +
				", emailAddress='" + emailAddress + '\'' +
				", rating='" + rating + '\'' +
				", properties=" + properties +
				'}';
	}
}