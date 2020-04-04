package au.com.easynebula.realestateprojectmanagement.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;

	@Column
	private String projectNumber;

	@Column
	private String name;

	@Column
	private String turnOver;

	@Column
	private String address;

	@Column
	private String state;

	@Column
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
		return "Project{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", turnOver='" + turnOver + '\'' +
				", address='" + address + '\'' +
				", state='" + state + '\'' +
				", projectManagerName='" + projectManagerName + '\'' +
				'}';
	}
}
