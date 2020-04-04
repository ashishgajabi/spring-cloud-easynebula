package au.com.easynebula.realestateagentmanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agent {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@Column(nullable = false, length = 12)
	private String agentNumber;
	
	@Column(nullable = false, length = 25)
	private String firstName;
	
	@Column(nullable = false, length = 25)
	private String lastName;
	
	@Column(length = 15)
	private String contactNumber;
	
	@Column
	private String emailAddress;
	
	@Column
	private String rating;

	public String getId() {
		return id;
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
}