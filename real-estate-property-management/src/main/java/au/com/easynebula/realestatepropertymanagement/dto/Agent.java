package au.com.easynebula.realestatepropertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@JsonPropertyOrder({
		"id",
		"agentNumber",
		"firstName",
		"lastName",
		"contactNumber",
		"emailAddress",
		"rating"
})
public class Agent {

	@JsonProperty("id")
	private String id;

	@JsonProperty("agentNumber")
	private String agentNumber;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("contactNumber")
	private String contactNumber;

	@JsonProperty("emailAddress")
	private String emailAddress;

	@JsonProperty("rating")
	private String rating;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAgentNumber() {
		return agentNumber;
	}

	public void setAgentNumber(String agentNumber) {
		this.agentNumber = agentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("agentNumber", agentNumber).append("firstName", firstName).append("lastName", lastName).append("contactNumber", contactNumber).append("emailAddress", emailAddress).append("rating", rating).toString();
	}

}