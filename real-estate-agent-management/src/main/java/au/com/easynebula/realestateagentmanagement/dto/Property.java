package au.com.easynebula.realestateagentmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"propertyNumber",
		"address",
		"postcode",
		"layout",
		"agentNumber"
})
public class Property {

	@JsonProperty("propertyNumber")
	private String propertyNumber;

	@JsonProperty("address")
	private String address;

	@JsonProperty("postcode")
	private String postcode;

	@JsonProperty("layout")
	private String layout;

	@JsonProperty("agentNumber")
	private String agentNumber;

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getAgentNumber() {
		return agentNumber;
	}

	public void setAgentNumber(String agentNumber) {
		this.agentNumber = agentNumber;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("propertyNumber", propertyNumber).append("address", address).append("postcode", postcode).append("layout", layout).append("agentNumber", agentNumber).toString();
	}
}