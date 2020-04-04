package au.com.easynebula.realestatepropertymanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Property {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;

	@Column
	private String propertyNumber;

	@Column
	private String address;

	@Column
	private String postcode;

	@Column
	private String layout;

	@Column
	private String agentNumber;

	@Column
	private String projectNumber;

	public String getId() {
		return id;
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

	public void setAgentNumber(String agentNumber) {
		this.agentNumber = agentNumber;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(final String projectNumber) {
		this.projectNumber = projectNumber;
	}
}
